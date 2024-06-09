package ru.praktikum.tracker.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.praktikum.tracker.model.Task;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryHistoryRepositoryTest {

    private InMemoryHistoryRepository repo;

    @BeforeEach
    void createObjects (){
        repo = new InMemoryHistoryRepository();
    }

    @Test
    void shouldAddTaskToViewHistory() {
        Task task = new Task("test_name", "test_description");
        repo.addTask(task);
        assertSame(task, repo.getHistory().get(0));
    }

    @Test
    void shouldReturnHistory() {
        Task task = new Task("test_name", "test_description");
        repo.addTask(task);
        assertNotNull(repo.getHistory());
        assertInstanceOf(ArrayList.class, repo.getHistory());
        assertSame(task, repo.getHistory().get(0));
    }
}