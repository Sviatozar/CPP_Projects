package org.example;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class SprintBacklogTest {

    SprintBacklog sprintBacklog = new SprintBacklog(20);
    Task task1 = new Task("abc", 8);
    Task task2 = new Task("abd", 13);

    @Test
    public void testAddTask() {
        sprintBacklog.addTask(task1);
        sprintBacklog.addTask(task2);
        assertEquals(2, sprintBacklog.getTaskList().size());
        assertTrue(sprintBacklog.getTaskList().contains(task1));
        assertTrue(sprintBacklog.getTaskList().contains(task2));
    }

    @Test
    public void testDeleteTask() {
        sprintBacklog.addTask(task1);
        sprintBacklog.addTask(task2);
        sprintBacklog.deleteTask(task1);
        assertEquals(1, sprintBacklog.getTaskList().size());
        assertFalse(sprintBacklog.getTaskList().contains(task1));
        assertTrue(sprintBacklog.getTaskList().contains(task2));
    }

    @Test
    public void testVerifySprintCapacityAfterAddingTasks() {
        sprintBacklog.addTask(task1);
        sprintBacklog.addTask(task2);

        int remainingCapacity = sprintBacklog.getCapacity();
        for (Task task : sprintBacklog.getTaskList()) {
            remainingCapacity -= task.getStoryPoints();
        }
        assertEquals(20, sprintBacklog.getCapacity());
    }
}