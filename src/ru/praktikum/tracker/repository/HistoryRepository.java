package ru.praktikum.tracker.repository;

import ru.praktikum.tracker.model.Task;

import java.util.ArrayList;

public interface HistoryRepository {
    void addTask(Task task);
    ArrayList<Task> getHistory();
}
