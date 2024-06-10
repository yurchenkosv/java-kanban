package ru.praktikum.tracker.repository;

import ru.praktikum.tracker.model.Task;

import java.util.ArrayList;

public class InMemoryHistoryRepository implements HistoryRepository{
    private ArrayList<Task> historyStorage;
    private static final Integer maxIdx = 10;

    public InMemoryHistoryRepository(){
        historyStorage = new ArrayList<>();
    }

    public void addTask(Task task) {
        if (task == null) {
            return;
        }
        historyStorage.add(task);
        if (historyStorage.size() > maxIdx) {
            historyStorage.removeFirst();
        }
    }
    public ArrayList<Task> getHistory(){
        return historyStorage;
    }
}
