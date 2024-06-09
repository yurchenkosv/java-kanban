package ru.praktikum.tracker.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    private Task task;

    @BeforeEach
    void initObjects(){
        task = new Task("test_task_name", "test_task_description");
    }

    @Test
    void shouldCreateObjectWithFieldsSet(){
        assertEquals(task.status, TaskStatus.status.NEW);
        assertEquals(task.name,"test_task_name" );
        assertEquals(task.description,"test_task_description" );
    }

    @Test
    void shouldReturnTaskID() {
        task.id = 1;
        assertEquals(1, task.getId());
    }

    @Test
    void shouldSetTaskID() {
        task.setId(1);
        assertEquals(1, task.id);
    }

    @Test
    void shouldSetTaskDescription() {
        task.setDescription("new_task_description");
        assertEquals("new_task_description", task.description);
    }

    @Test
    void shouldSetTaskName() {
        task.setName("new_task_name");
        assertEquals("new_task_name", task.name);
    }

    @Test
    void shouldSetStatus() {
        task.setStatus(TaskStatus.status.IN_PROGRESS);
        assertEquals(TaskStatus.status.IN_PROGRESS, task.status);
    }

    @Test
    void shouldReturnStatus() {
        task.status = TaskStatus.status.DONE;
        assertEquals(TaskStatus.status.DONE, task.getStatus());
    }
}