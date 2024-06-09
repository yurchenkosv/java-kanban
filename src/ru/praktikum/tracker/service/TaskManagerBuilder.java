package ru.praktikum.tracker.service;

import ru.praktikum.tracker.repository.HistoryRepository;
import ru.praktikum.tracker.repository.TaskRepository;

public class TaskManagerBuilder {
    private TaskRepository taskRepository;
    private HistoryRepository historyRepository;


    protected TaskRepository getTaskRepository() {
        return taskRepository;
    }

    protected HistoryRepository getHistoryRepository() {
        return historyRepository;
    }

    public TaskManagerBuilder withTaskRepository(TaskRepository repo){
        this.taskRepository = repo;
        return this;
    }

    public TaskManagerBuilder withHistoryRepository(HistoryRepository historyRepository){
        this.historyRepository= historyRepository;
        return this;
    }

    public Manager build() {
        if (taskRepository ==null){
            taskRepository = Util.getDefaultTaskRepository();
        }
        if (historyRepository == null) {
            historyRepository = Util.getDefaultHistoryRepository();
        }
        return new TaskManager(this.taskRepository, this.historyRepository);
    }
}
