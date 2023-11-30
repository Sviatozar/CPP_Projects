package org.example;

import java.util.Objects;

public class Developer {
    private String name;
    private String lastName;
    private double salary;
    private Position position;
    private int doneTaskCount;
    private int score;

    public Developer(String name, String lastName, double salary, Position position) {
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
        this.position = position;
        this.doneTaskCount = 0;
        this.score = 0;
    }

    public Task getTaskFromSprintBacklog(SprintBacklog sprintBacklog) {
        Task task = sprintBacklog.getNextTask();
        if (task != null) {
            doneTaskCount++;
            score += task.getStoryPoints();
            markTaskAsValidate(task);
        }
        return task;
    }

    public void markTaskAsValidate(Task task) {
        task.setStatus(Status.VALIDATE);
    }
    public int getDoneTaskCount() {
        return doneTaskCount;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return Double.compare(developer.salary, salary) == 0 &&
                doneTaskCount == developer.doneTaskCount &&
                score == developer.score &&
                Objects.equals(name, developer.name) &&
                Objects.equals(lastName, developer.lastName) &&
                position == developer.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, salary, position, doneTaskCount, score);
    }
}
