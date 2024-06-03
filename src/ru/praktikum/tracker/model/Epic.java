package ru.praktikum.tracker.model;

import java.util.ArrayList;

public class Epic extends Task{
    private ArrayList<Subtask> linkedSubTasks;
    public Epic(String name, String description){
        super(name, description);
        linkedSubTasks = new ArrayList<>();
    }

    public void linkSubtask(Subtask task){
        task.setEpicLink(this);
        linkedSubTasks.add(task);
    }

    public ArrayList<Subtask> getLinkedSubTasks(){
        return linkedSubTasks;
    }

    public void cleanSubtaskIds(){
        linkedSubTasks.clear();
    }

    @Override
    public String toString() {
        return "Epic{" +
                "linkedSubTasks=" + linkedSubTasks +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}

