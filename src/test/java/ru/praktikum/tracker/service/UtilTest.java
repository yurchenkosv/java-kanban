package ru.praktikum.tracker.service;

import org.junit.jupiter.api.Test;
import ru.praktikum.tracker.repository.HistoryRepository;
import ru.praktikum.tracker.repository.TaskRepository;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    @Test
    void shouldGetDefaultTaskRepo() {
        assertInstanceOf(TaskRepository.class, Util.getDefaultTaskRepository());
    }
    @Test
    void shouldGetDefaultHistoryRepo(){
        assertInstanceOf(HistoryRepository.class, Util.getDefaultHistoryRepository());
    }

}