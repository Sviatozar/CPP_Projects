package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TeamLeadTest {

    TeamLead teamLead = new TeamLead("John", "Doe", 10000);
    ProductBacklog productBacklog = new ProductBacklog();
    Task criticalTask = new Task("Critical", 100, Priority.CRITICAL);
    Task highTask = new Task("High", 40, Priority.HIGH);
    Task normalTask = new Task("Normal", 20, Priority.NORMAL);
    Task lowTask = new Task("Low", 13, Priority.LOW);
    Task doneTask = new Task("Done", 20);
    SprintBacklog sprintBacklog = new SprintBacklog(30);

    @Test
    void moveTasksFromProductToSprintBacklog() {
        productBacklog.addTask(criticalTask);
        assertEquals(0, sprintBacklog.getTaskList().size());
        teamLead.moveTasksFromProductToSprintBacklog(criticalTask, sprintBacklog, productBacklog);
        assertEquals(0, productBacklog.getTaskQueue().size());
        assertEquals(1, sprintBacklog.getTaskList().size());
        assertEquals("Critical", sprintBacklog.getTaskList().get(0).getName());
    }

    @Test
    public void markTaskAsDone() {
        teamLead.markTaskAsDone(doneTask);
        assertEquals(Status.DONE, doneTask.getStatus());
    }

    @Test
    public void inspectSprintBacklog() {
        sprintBacklog.addTask(doneTask);
        sprintBacklog.addTask(normalTask);
        teamLead.inspectSprintBacklog(sprintBacklog);
        assertEquals("Done", sprintBacklog.getTaskList().get(0).getName());
        assertEquals(2, sprintBacklog.getTaskList().size());
    }
}