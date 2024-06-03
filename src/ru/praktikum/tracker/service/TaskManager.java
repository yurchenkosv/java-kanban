package ru.praktikum.tracker.service;

import ru.praktikum.tracker.model.*;
import ru.praktikum.tracker.repository.TaskRepository;

import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager {

    private final TaskRepository repo;
    private static int taskID;

    public TaskManager(TaskRepository repository){
        this.repo = repository;
    }

    public void create(Task obj){
        obj.setId(++taskID);
        repo.add(obj);
    }

    public void create(Subtask obj){
        obj.setId(++taskID);
        repo.add(obj);
    }

    public void create(Epic obj){
        obj.setId(++taskID);
        repo.add(obj);
    }

    public Task getTaskByID(Integer id){
        return repo.getTaskByID(id);
    }

    public Epic getEpicByID(Integer id){
        return repo.getEpicByID(id);
    }

    public Subtask getSubtaskByID(Integer id){
        return repo.getSubtaskByID(id);
    }

    public ArrayList<Subtask> getEpicTasks(Epic epic){
        return epic.getLinkedSubTasks();
    }

    public void update(Task task){
        repo.update(task);
    }

    public void update(Epic epic){
        ArrayList<Subtask> taskList = epic.getLinkedSubTasks();
        int newCounter = 0;
        int doneConunter = 0;
        for (Task task : taskList) {
           if (task.getStatus() == TaskStatus.status.NEW){
               newCounter++;
           } else if (task.getStatus() == TaskStatus.status.DONE) {
               doneConunter++;
           }
        }
        if (newCounter == taskList.size()) {
            epic.setStatus(TaskStatus.status.NEW);
        } else if ( doneConunter == taskList.size()){
            epic.setStatus(TaskStatus.status.DONE);
        } else {
            epic.setStatus(TaskStatus.status.IN_PROGRESS);
        }

        repo.update(epic);
    }

    public void update(Subtask subtask){
        Epic epic = subtask.getEpicLink();
        repo.update(subtask);
        this.update(epic);
    }

    public void delete(Task task){
        repo.delete(task);
    }
    public void delete(Subtask subtask){
        repo.delete(subtask);
    }
    public void delete(Epic epic){
        repo.delete(epic);
    }

    public void deleteTasks(){
        repo.deleteAllTasks();
    }
    public void deleteSubtasks(){
        HashMap<Integer, Epic> epics = repo.getEpics();
        for (Epic epic:epics.values()) {
            epic.cleanSubtaskIds();
            this.update(epic);
        }
        repo.deleteAllSubtask();
    }
    public void deleteEpics(Epic epic){
        repo.deleteAllEpics();
        repo.deleteAllSubtask();
    }

}
