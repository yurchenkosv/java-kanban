package ru.praktikum.local.kanban;

import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager {

    private HashMap<Integer, Task> tasks;
    private HashMap<Integer, Epic> epics;
    private HashMap<Integer, Subtask> subtasks;
    static int taskID;

    public TaskManager(){
        tasks = new HashMap<>();
        epics = new HashMap<>();
        subtasks = new HashMap<>();
    }

    public void  Create(Task obj){
        obj.id = ++taskID;
        tasks.put(obj.getId(), obj);
    }

    public void Create(Subtask obj){
        obj.id = ++taskID;
        subtasks.put(obj.getId(), obj);
    }

    public void Create(Epic obj){
        obj.id = ++taskID;
        epics.put(obj.getId(), obj);
    }

    public Task GetTaskByID(Integer id){
        return tasks.get(id);
    }

    public Epic GetEpicByID(Integer id){
        return epics.get(id);
    }

    public Subtask GetSubtaskByID(Integer id){
        return subtasks.get(id);
    }

    public ArrayList<Task> GetEpicTasks(Epic epic){
        return epic.GetLinkedTasks();
    }

    public void Update (Task task){
        tasks.replace(task.getId(),task);
        this.Update(task.getEpicLink());
    }

    public void Update (Epic epic){
        ArrayList<Task> taskList = epic.GetLinkedTasks();
        int newCounter = 0;
        int doneConunter = 0;
        for (Task task : taskList) {
           if (task.status == TaskStatus.status.NEW){
               newCounter++;
           } else if (task.status == TaskStatus.status.DONE) {
               doneConunter++;
           }
        }
        if (newCounter == taskList.size()) {
            epic.status = TaskStatus.status.NEW;
        } else if ( doneConunter == taskList.size()){
            epic.status = TaskStatus.status.DONE;
        } else {
            epic.status = TaskStatus.status.IN_PROGRESS;
        }

        epics.replace(epic.getId(), epic);
    }

    public void Update (Subtask subtask){
        subtasks.replace(subtask.getId(), subtask);
    }

    public void DeleteAll() {
        tasks.clear();
        epics.clear();
        subtasks.clear();
    }

}
