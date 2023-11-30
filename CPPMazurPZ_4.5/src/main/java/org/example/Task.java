package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Task {
    private static int nextId = 1;

    private int id;
    private String name;
    private Status status;
    private int storyPoints;
    private Priority priority;

    public Task(String name, int storyPoints) {
        this.id = getNextId();
        this.name = name;
        this.status = Status.TO_DO;
        setStoryPoints(storyPoints);
        this.priority = getRandomPriority();
    }

    public Task(String name, int storyPoints, Priority priority) {
        this.id = getNextId();
        this.name = name;
        this.status = Status.TO_DO;
        setStoryPoints(storyPoints);
        this.priority = priority;
    }

    private synchronized int getNextId() {
        return nextId++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public int getStoryPoints() {
        return storyPoints;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private void setStoryPoints(int storyPoints) {
        List<Integer> allowedStoryPoints = Arrays.asList(1, 2, 3, 5, 8, 13, 20, 40, 100);
        if (allowedStoryPoints.contains(storyPoints)) {
            this.storyPoints = storyPoints;
        } else {
            throw new IllegalArgumentException("Invalid story points value");
        }
    }

    private Priority getRandomPriority() {
        Priority[] priorities = Priority.values();
        return priorities[new Random().nextInt(priorities.length)];
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task task = (Task) obj;
        return id == task.id &&
                storyPoints == task.storyPoints &&
                Objects.equals(name, task.name) &&
                status == task.status &&
                priority == task.priority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status, storyPoints, priority);
    }

}