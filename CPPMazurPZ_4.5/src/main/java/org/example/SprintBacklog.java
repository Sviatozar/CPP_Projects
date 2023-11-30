package org.example;

import java.util.ArrayList;
import java.util.List;

public class SprintBacklog {
    private List<Task> taskList;
    private int capacity;

    public SprintBacklog(int capacity) {
        this.taskList = new ArrayList<>();
        this.capacity = capacity;
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void deleteTask(Task task) {
        taskList.remove(task);
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> list) {
        this.taskList = list;
    }

    public Task getNextTask() {
        if (!taskList.isEmpty()) {
            Task nextTask = taskList.get(0);
            taskList.remove(0);
            return nextTask;
        } else {
            return null;
        }
    }

    public int getCapacity() {
        return capacity;
    }
}
