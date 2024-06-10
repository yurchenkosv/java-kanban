package ru.praktikum.tracker.repository;

import ru.praktikum.tracker.model.Epic;
import ru.praktikum.tracker.model.Subtask;
import ru.praktikum.tracker.model.Task;

import java.util.HashMap;
import java.util.List;

public interface TaskRepository {
     void  add(Task obj);
     void  add(Epic obj);
     void  add(Subtask obj);

     Task getTaskByID(Integer id);
     Epic getEpicByID(Integer id);
     Subtask getSubtaskByID(Integer id);

     List<Task> getTasks();
     List<Epic> getEpics() ;
     List<Subtask> getSubtasks();

     void update(Task obj);
     void update(Epic obj);
     void update(Subtask obj);

     void delete(Task obj);
     void delete(Epic obj);
     void delete(Subtask obj);

     void deleteAllTasks();
     void deleteAllEpics();
     void deleteAllSubtask();

}
