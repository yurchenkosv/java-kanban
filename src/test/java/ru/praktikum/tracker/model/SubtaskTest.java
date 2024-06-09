package ru.praktikum.tracker.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtaskTest {

    private Subtask subtask;
    private Epic epic;

    @BeforeEach
    void initObjects(){
        subtask = new Subtask("test_subtask_name", "test_subtask_description");
        epic = new Epic("test_epic_name", "test_epic_description");
    }

    @Test
    void checkConstructor(){
        assertEquals(subtask.name, "test_subtask_name");
        assertEquals(subtask.status, TaskStatus.status.NEW);
        assertEquals(subtask.description, "test_subtask_description");
    }

    @Test
    void shouldSuccessfullyGetEpicLink() {
        subtask.setEpicLink(epic);
        assertSame(epic, subtask.getEpicLink());
    }
}