package ru.praktikum.tracker.repository;

import ru.praktikum.tracker.model.Epic;
import ru.praktikum.tracker.model.Subtask;
import ru.praktikum.tracker.model.Task;

import java.util.HashMap;

public class InMemoryTaskRepository implements TaskRepository {
    private HashMap<Integer, Task> tasks;
    private HashMap<Integer, Epic> epics;
    private HashMap<Integer, Subtask> subtasks;

    public InMemoryTaskRepository(){
        tasks = new HashMap<>();
        epics = new HashMap<>();
        subtasks = new HashMap<>();
    }

    public void add(Task obj){
        tasks.put(obj.getId(), obj);
    }
    public void add(Epic obj){
        epics.put(obj.getId(), obj);
    }
    public void add(Subtask obj){
        subtasks.put(obj.getId(),obj);
    }

    public Task getTaskByID(Integer id){
        return tasks.get(id);
    }
    public Epic getEpicByID(Integer id){
        return epics.get(id);
    }
    public Subtask getSubtaskByID(Integer id){
        return subtasks.get(id);
    }

    public HashMap<Integer, Task> getTasks() {
        return tasks;
    }

    public HashMap<Integer, Epic> getEpics() {
        return epics;
    }

    public HashMap<Integer, Subtask> getSubtasks() {
        return subtasks;
    }

    public void update(Task obj){
        add(obj);
    }
    public void update(Epic obj){
        add(obj);
    }
    public void update(Subtask obj){
        add(obj);
    }

    public void delete(Task obj){
        tasks.remove(obj.getId());
    }
    public void delete(Epic obj){
        epics.remove(obj.getId());
    }
    public void delete(Subtask obj){
        subtasks.remove(obj.getId());
    }

    public void deleteAllTasks(){
        tasks.clear();
    }
    public void deleteAllEpics(){
        epics.clear();
    }
    public void deleteAllSubtask(){
        subtasks.clear();
    }

}
