package org.example;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ProductBacklog {

    private final Queue<Task> taskQueue;

    public ProductBacklog() {
        this.taskQueue = new LinkedList<>();
    }

    public void swapTasks(Task task1, Task task2) {
        Queue<Task> tempQueue = new LinkedList<>();
        Task currentTask;
        boolean found1 = false;
        boolean found2 = false;
        while (!taskQueue.isEmpty()) {
            currentTask = taskQueue.poll();

            if (currentTask.equals(task1) && !found1) {
                tempQueue.offer(task2);
                found1 = true;
            } else if (currentTask.equals(task2) && !found2) {
                tempQueue.offer(task1);
                found2 = true;
            } else {
                tempQueue.offer(currentTask);
            }
        }
        taskQueue.addAll(tempQueue);
    }

    public Queue<Task> getTaskQueue() {
        return taskQueue;
    }

    public void addTask(Task task) {
        taskQueue.offer(task);
    }

    public void deleteTask(Task task) {
        taskQueue.remove(task);
    }

    public void printProductBacklog() {
        System.out.println("Product Backlog:");
        for (Task task : taskQueue) {
            System.out.println("Task ID: " + task.getId() +
                    ", Name: " + task.getName() +
                    ", Priority: " + task.getPriority());
        }
    }

}