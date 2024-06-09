package ru.praktikum.tracker.repository;

import ru.praktikum.tracker.model.Task;

import java.util.ArrayList;

public interface HistoryRepository {
    public void addTask(Task task);
    public ArrayList<Task> getHistory();
}
