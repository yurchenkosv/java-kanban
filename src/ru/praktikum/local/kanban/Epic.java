package ru.praktikum.local.kanban;

import java.util.ArrayList;

public class Epic extends Task{
    private ArrayList<Task> linkedTasks;
    public Epic(String name, String description){
        super(name, description);
        linkedTasks = new ArrayList<>();
    }

    public void LinkTask(Task task){
        linkedTasks.add(task);
        task.setEpicLink(this);
    }

    public ArrayList<Task> GetLinkedTasks(){
        return linkedTasks;
    }

    @Override
    public String toString() {
        return "Epic{" +
                "linkedTasks=" + linkedTasks +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}

