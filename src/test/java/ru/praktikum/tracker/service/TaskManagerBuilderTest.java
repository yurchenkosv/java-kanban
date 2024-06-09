package ru.praktikum.tracker.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.praktikum.tracker.repository.InMemoryHistoryRepository;
import ru.praktikum.tracker.repository.InMemoryTaskRepository;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerBuilderTest {
    protected TaskManagerBuilder builder;

    @BeforeEach
    void createObjects(){
        builder = new TaskManagerBuilder();
    }

    @Test
    void shouldCreateBuilderWithTaskRepositorySet() {
      builder.withTaskRepository(new InMemoryTaskRepository());
      assertNotNull(builder.getTaskRepository());
      assertNull(builder.getHistoryRepository());
    }

    @Test
    void shouldCreateBuilderWithHistoryRepositorySet() {
        builder.withHistoryRepository(new InMemoryHistoryRepository());
        assertNull(builder.getTaskRepository());
        assertNotNull(builder.getHistoryRepository());
    }

    @Test
    void shouldCreateTaskManagerWithDefaults() {
        Manager manager = builder.build();
        assertNotNull(builder.getTaskRepository());
        assertNotNull(builder.getHistoryRepository());
        assertInstanceOf(InMemoryTaskRepository.class, builder.getTaskRepository());
        assertInstanceOf(InMemoryHistoryRepository.class, builder.getHistoryRepository());
        assertInstanceOf(TaskManager.class, manager);
    }
}