package ru.praktikum.tracker.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EpicTest {
    private Epic epic;

    @BeforeEach
    void createEpic (){
        epic = new Epic("test_epic", "test_description");
    }

    @Test
    void shouldCreateEpic(){
        assertEquals(epic.name, "test_epic");
        assertEquals(epic.description, "test_description");
        assertInstanceOf(Task.class, epic);
    }

    @Test
    void shouldLinkSubtask() {
        Subtask stask = new Subtask("test_subtask", "test_subtask_description");
        epic.linkSubtask(stask);
        Subtask linkedSubtask = epic.getLinkedSubTasks().get(0);
        assertSame(stask, linkedSubtask);
    }

    @Test
    void cleanSubtaskIds() {
        Subtask stask = new Subtask("test_subtask", "test_subtask_description");
        epic.linkSubtask(stask);
        assertEquals(epic.getLinkedSubTasks().size(), 1);
        epic.cleanSubtaskIds();
        assertEquals(epic.getLinkedSubTasks().size(), 0);
    }
}