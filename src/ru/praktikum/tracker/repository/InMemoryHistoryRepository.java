package ru.praktikum.tracker.repository;

import ru.praktikum.tracker.model.Task;

import java.util.ArrayList;

public class InMemoryHistoryRepository implements HistoryRepository{
    private ArrayList<Task> historyStorage;
    private Integer storageIdx;
    private static final Integer maxIdx = 10;


    public Integer getStorageIdx() {
        return storageIdx;
    }

    public InMemoryHistoryRepository(){
        storageIdx = 0;
        historyStorage = new ArrayList<>();
    }

    public void addTask(Task task){
        if (historyStorage.size()>=maxIdx){
            storageIdx = 0;
        }
        historyStorage.add(storageIdx, task);
        storageIdx++;
    }

    public ArrayList<Task> getHistory(){
        return historyStorage;
    }
}
