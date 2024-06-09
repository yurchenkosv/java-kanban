package ru.praktikum.tracker.service;

import ru.praktikum.tracker.model.Epic;
import ru.praktikum.tracker.model.Subtask;
import ru.praktikum.tracker.model.Task;

import java.util.ArrayList;

public interface Manager {
    void create(Task obj);

    void create(Subtask obj);

    void create(Epic obj);

    Task getTaskByID(Integer id);

    Epic getEpicByID(Integer id);

    Subtask getSubtaskByID(Integer id);

    ArrayList<Subtask> getEpicTasks(Epic epic);

    ArrayList<Task> getHistory();

    void update(Task task);

    void update(Epic epic);

    void update(Subtask subtask);

    void delete(Task task);

    void delete(Subtask subtask);

    void delete(Epic epic);

    void deleteTasks();

    void deleteSubtasks();

    void deleteEpics();
}
