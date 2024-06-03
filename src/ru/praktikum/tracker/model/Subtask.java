package ru.praktikum.tracker.model;

public class Subtask extends Task{

    private Epic epicLink;

    public Subtask(String name, String description){
        super(name, description);
    }

    public Epic getEpicLink() {
        return epicLink;
    }

    public void setEpicLink(Epic epicLink) {
        this.epicLink = epicLink;
    }

    @Override
    public String toString() {
        return "Subtask{" +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
