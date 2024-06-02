package ru.praktikum.local.kanban;


public class Task {

    protected String name;
    protected String description;
    int id;
    private Epic epicLink;

    TaskStatus.status status;

    public Task(String name, String description){
        this.name = name;
        this.description = description;
        this.status = TaskStatus.status.NEW;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(TaskStatus.status status) {
        this.status = status;
    }

    public void setEpicLink(Epic epicLink) {
        this.epicLink = epicLink;
    }

    public Epic getEpicLink() {
        return epicLink;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
