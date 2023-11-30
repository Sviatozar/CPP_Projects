package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TeamLead {
    private String name;
    private String lastName;
    private double salary;
    private Position position;

    public TeamLead(String name, String lastName, double salary) {
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
        this.position = Position.TEAM_LEAD;
    }

    public void moveTasksFromProductToSprintBacklog(Task task, SprintBacklog sprintBacklog, ProductBacklog productBacklog) {
        if (productBacklog.getTaskQueue().contains(task)) {
            productBacklog.deleteTask(task);
            sprintBacklog.addTask(task);
        }
    }

    public void markTaskAsDone(Task task) {
        task.setStatus(Status.DONE);
    }

    public void inspectSprintBacklog(SprintBacklog sprintBacklog) {
        List<Task> temp = sprintBacklog.getTaskList();
        for (Task task :
                temp) {
            if (task.getStatus() == Status.DONE) {
                temp.remove(task);
            }
        }
        sprintBacklog.setTaskList(temp);
    }
}
