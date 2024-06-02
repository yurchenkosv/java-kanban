package ru.praktikum.local.kanban;

public class Subtask extends Task{
    private Task headTaskLink;
    public Subtask(String name, String description, Task headTask){
        super(name, description);
        headTaskLink = headTask;
    }
    public Task getHeadTaskLink() {
        return headTaskLink;
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "headTaskLink=" + headTaskLink +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
