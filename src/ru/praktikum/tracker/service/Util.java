package ru.praktikum.tracker.service;

import ru.praktikum.tracker.repository.HistoryRepository;
import ru.praktikum.tracker.repository.InMemoryHistoryRepository;
import ru.praktikum.tracker.repository.InMemoryTaskRepository;
import ru.praktikum.tracker.repository.TaskRepository;

public class Util {

    protected static TaskRepository getDefaultTaskRepository(){
        return new InMemoryTaskRepository();
    }

    protected static HistoryRepository getDefaultHistoryRepository(){
        return new InMemoryHistoryRepository();
    }
}
