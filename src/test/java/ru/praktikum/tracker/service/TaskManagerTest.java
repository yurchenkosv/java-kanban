package ru.praktikum.tracker.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.praktikum.tracker.model.Epic;
import ru.praktikum.tracker.model.Subtask;
import ru.praktikum.tracker.model.Task;
import ru.praktikum.tracker.model.TaskStatus;
import ru.praktikum.tracker.repository.HistoryRepository;
import ru.praktikum.tracker.repository.InMemoryHistoryRepository;
import ru.praktikum.tracker.repository.InMemoryTaskRepository;
import ru.praktikum.tracker.repository.TaskRepository;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {

    private TaskManager taskManager;
    private HistoryRepository historyRepository;
    private TaskRepository taskRepository;

    @BeforeEach
    void createObects(){
        historyRepository = new InMemoryHistoryRepository();
        taskRepository = new InMemoryTaskRepository();
        taskManager = new TaskManager(taskRepository,historyRepository);
        TaskManager.taskID = 0;
    }

    @Test
    void shouldCreateTask() {
        Task task = new Task("test_name", "test_description");
        taskManager.create(task);
        assertEquals(1, task.getId());
    }

    @Test
    void shouldCreateEpic() {
        Epic epic = new Epic("test_name", "test_description");
        taskManager.create(epic);
        assertEquals(1, epic.getId());
    }

    @Test
    void shouldCreateSubtask() {
        Subtask subtask = new Subtask("test_name", "test_description");
        taskManager.create(subtask);
        assertEquals(1, subtask.getId());
    }

    @Test
    void shouldReturnTaskByID() {
        Task task = new Task("test_name", "test_description");
        taskManager.create(task);
        assertSame(task, taskManager.getTaskByID(1));
    }

    @Test
    void shouldReturnEpicByID() {
        Epic obj = new Epic("test_name", "test_description");
        taskManager.create(obj);
        assertSame(obj, taskManager.getEpicByID(1));
    }

    @Test
    void shouldReturnSubtaskByID() {
        Subtask obj = new Subtask("test_name", "test_description");
        taskManager.create(obj);
        assertSame(obj, taskManager.getSubtaskByID(1));
    }

    @Test
    void shouldReturnEpicTasks() {
        Epic epic = new Epic("test_name", "test_description");
        taskManager.create(epic);
        Subtask subtask = new Subtask("test_subtask_name", "test_subtask_descruption");
        epic.linkSubtask(subtask);
        assertInstanceOf(ArrayList.class, taskManager.getEpicTasks(epic));
        assertSame(subtask, taskManager.getEpicTasks(epic).get(0));
    }

    @Test
    void shouldReturnViewHistory() {
        Task task = new Task("test_name", "test_description");
        taskManager.create(task);
        taskManager.getTaskByID(1);
        assertInstanceOf(ArrayList.class, taskManager.getHistory());
        assertSame(task, taskManager.getHistory().get(0));
    }

    @Test
    void shouldUpdateTask() {
        Task task = new Task("test_name", "test_description");
        taskManager.create(task);
        task.setStatus(TaskStatus.status.DONE);
        taskManager.update(task);
        assertEquals(taskManager.getTaskByID(1).getStatus(), TaskStatus.status.DONE);
    }

    @Test
    void shouldUpdateSubtaskWithoutEpicLink() {
        Subtask obj = new Subtask("test_name", "test_description");
        taskManager.create(obj);
        obj.setStatus(TaskStatus.status.DONE);
        taskManager.update(obj);
        assertEquals(taskManager.getSubtaskByID(1).getStatus(), TaskStatus.status.DONE);
    }

    @Test
    void shouldUpdateSubtaskWithEpicLink() {
        Subtask subtask = new Subtask("test_name", "test_description");
        taskManager.create(subtask);
        Epic epic = new Epic("test_epic_name", "test_epic_description");
        taskManager.create(epic);

        epic.linkSubtask(subtask);
        subtask.setStatus(TaskStatus.status.DONE);
        taskManager.update(subtask);

        assertEquals(TaskStatus.status.DONE, taskManager.getSubtaskByID(1).getStatus());
        assertEquals(TaskStatus.status.DONE, taskManager.getEpicByID(2).getStatus());
    }


    @Test
    void shouldDeleteSubtask() {
        Subtask subtask = new Subtask("test_name", "test_description");
        taskManager.create(subtask);
        assertNotNull(taskManager.getSubtaskByID(1));
        taskManager.delete(subtask);
        assertNull(taskManager.getSubtaskByID(1));
    }

    @Test
    void shouldDeleteTask() {
        Task task = new Task("test_name", "test_description");
        taskManager.create(task);
        assertNotNull(taskManager.getTaskByID(1));
        taskManager.delete(task);
        assertNull(taskManager.getTaskByID(1));
    }

    @Test
    void shouldDeleteEpic() {
        Epic epic = new Epic("test_name", "test_description");
        taskManager.create(epic);
        assertNotNull(taskManager.getEpicByID(1));
        taskManager.delete(epic);
        assertNull(taskManager.getEpicByID(1));
    }

    @Test
    void deleteTasks() {
        Task task = new Task("test_name", "test_description");
        taskManager.create(task);
        assertNotNull(taskManager.getTaskByID(1));
        taskManager.deleteTasks();
        assertNull(taskManager.getTaskByID(1));
    }

    @Test
    void deleteSubtasks() {
        Subtask subtask = new Subtask("test_name", "test_description");
        taskManager.create(subtask);
        Epic epic = new Epic("test_epic_name", "test_epic_description");
        taskManager.create(epic);

        epic.linkSubtask(subtask);
        taskManager.deleteSubtasks();

        assertNull(taskManager.getSubtaskByID(1));
        assertEquals(0, taskManager.getEpicTasks(epic).size());
    }

    @Test
    void deleteEpics() {
        Subtask subtask = new Subtask("test_name", "test_description");
        taskManager.create(subtask);
        Epic epic = new Epic("test_epic_name", "test_epic_description");
        taskManager.create(epic);

        epic.linkSubtask(subtask);
        taskManager.deleteEpics();

        assertNull(taskManager.getSubtaskByID(1));
        assertNull(taskManager.getEpicByID(2));
    }
}