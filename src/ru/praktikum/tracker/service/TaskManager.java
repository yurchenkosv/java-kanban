package ru.praktikum.tracker.service;

import ru.praktikum.tracker.model.*;
import ru.praktikum.tracker.repository.HistoryRepository;
import ru.praktikum.tracker.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

public class TaskManager implements Manager {

    private final TaskRepository taskRepository;
    private final HistoryRepository historyRepository;
    protected static int taskID;

    public TaskManager(TaskRepository taskRepository, HistoryRepository historyRepository){
        this.taskRepository = taskRepository;
        this.historyRepository = historyRepository;
    }

    @Override
    public void create(Task obj){
        obj.setId(++taskID);
        taskRepository.add(obj);
    }

    @Override
    public void create(Subtask obj){
        obj.setId(++taskID);
        taskRepository.add(obj);
    }

    @Override
    public void create(Epic obj){
        obj.setId(++taskID);
        taskRepository.add(obj);
    }

    @Override
    public Task getTaskByID(Integer id){
        Task result =  taskRepository.getTaskByID(id);
        historyRepository.addTask(result);
        return result;
    }

    @Override
    public Epic getEpicByID(Integer id){
        Epic result = taskRepository.getEpicByID(id);
        historyRepository.addTask(result);
        return result;
    }

    @Override
    public Subtask getSubtaskByID(Integer id){
        Subtask result = taskRepository.getSubtaskByID(id);
        historyRepository.addTask(result);
        return result;
    }

    @Override
    public ArrayList<Subtask> getEpicTasks(Epic epic){
        ArrayList<Subtask> result = epic.getLinkedSubTasks();
        for (Subtask subtask: result){
            historyRepository.addTask(subtask);
        }
        return result;
    }

    public ArrayList<Task> getHistory(){
        return historyRepository.getHistory();
    }


    public List<Epic> getAllEpics(){
        return taskRepository.getEpics();
    }

    public List<Subtask> getAllSubtask(){
        return taskRepository.getSubtasks();
    }

    public List<Task> getAllTasks(){
        return taskRepository.getTasks();
    }

    @Override
    public void update(Task task){
        taskRepository.update(task);
    }

    @Override
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

        taskRepository.update(epic);
    }

    @Override
    public void update(Subtask subtask){
        Epic epic = subtask.getEpicLink();
        taskRepository.update(subtask);
        if (epic != null ){
            this.update(epic);
        }
    }

    @Override
    public void delete(Task task){
        taskRepository.delete(task);
    }
    @Override
    public void delete(Subtask subtask){
        taskRepository.delete(subtask);
    }
    @Override
    public void delete(Epic epic){
        taskRepository.delete(epic);
    }

    @Override
    public void deleteTasks(){
        taskRepository.deleteAllTasks();
    }
    @Override
    public void deleteSubtasks(){
        List< Epic> epics = taskRepository.getEpics();
        for (Epic epic:epics) {
            epic.cleanSubtaskIds();
            this.update(epic);
        }
        taskRepository.deleteAllSubtask();
    }
    @Override
    public void deleteEpics(){
        taskRepository.deleteAllEpics();
        taskRepository.deleteAllSubtask();
    }

}
