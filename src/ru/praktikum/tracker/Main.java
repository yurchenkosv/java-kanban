package ru.praktikum.tracker;

import ru.praktikum.tracker.model.Subtask;
import ru.praktikum.tracker.repository.InMemoryTaskRepository;
import ru.praktikum.tracker.repository.TaskRepository;
import ru.praktikum.tracker.service.TaskManager;
import ru.praktikum.tracker.model.Epic;
import ru.praktikum.tracker.model.Task;
import ru.praktikum.tracker.model.TaskStatus;

public class Main {

    public static void main(String[] args) {
        System.out.println("Поехали!");

        TaskRepository repo = new InMemoryTaskRepository();

        Task firstTestTask = new Task("first test task", " description for first test task");
        Task secondTestTask = new Task("second test task", " description for second test task");

        Epic firstEpic = new Epic("first test epic", "first epic description");
        Epic secondEpic = new Epic("second test epic", "second epic description");

        Subtask firstSubtask = new Subtask("test subtask", "test decription for subtask");
        Subtask secondSubtask = new Subtask("test subtask", "test decription for subtask");

        TaskManager tm = new TaskManager(repo);

        tm.create(firstTestTask);
        tm.create(secondTestTask);
        tm.create(firstSubtask);
        tm.create(firstEpic);
        tm.create(secondEpic);


        firstEpic.linkSubtask(firstSubtask);
        firstEpic.linkSubtask(secondSubtask);

        System.out.println(tm.getEpicByID(firstEpic.getId()));
        System.out.println(tm.getEpicByID(secondEpic.getId()));
        System.out.println(tm.getTaskByID(firstTestTask.getId()));
        System.out.println(tm.getTaskByID(secondTestTask.getId()));

        firstTestTask.setStatus(TaskStatus.status.DONE);
        secondTestTask.setStatus(TaskStatus.status.IN_PROGRESS);
        tm.update(firstTestTask);
        tm.update(secondTestTask);

        firstSubtask.setStatus(TaskStatus.status.IN_PROGRESS);
        secondSubtask.setStatus(TaskStatus.status.IN_PROGRESS);
        tm.update(firstSubtask);
        tm.update(secondSubtask);

        System.out.println("\n\n");
        System.out.println(tm.getEpicByID(firstEpic.getId()));
        System.out.println(tm.getEpicByID(secondEpic.getId()));
        System.out.println(tm.getTaskByID(firstTestTask.getId()));
        System.out.println(tm.getTaskByID(secondTestTask.getId()));

    }
}
