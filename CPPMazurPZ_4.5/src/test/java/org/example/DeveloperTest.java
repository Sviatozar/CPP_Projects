package org.example;

import junit.framework.TestCase;
import org.junit.Test;

public class DeveloperTest extends TestCase {
    SprintBacklog sprintBacklog = new SprintBacklog(20);
    Developer developer = new Developer("A", "B", 10000, Position.BACKEND_DEVELOPER);
    Task task1 = new Task("abc", 8);
    Task task2 = new Task("abd", 13);

    @Test
    public void testGetTaskFromSprintBacklog() {
        sprintBacklog.addTask(task1);
        sprintBacklog.addTask(task2);
        Task assignedTask = developer.getTaskFromSprintBacklog(sprintBacklog);
        assertNotNull(assignedTask);
        assertEquals("abc", assignedTask.getName());
        assertEquals(8, assignedTask.getStoryPoints());
        assertEquals(1, developer.getDoneTaskCount());
        assertEquals(8, developer.getScore());
        assertFalse(sprintBacklog.getTaskList().contains(assignedTask));
    }

    @Test
    public void testGetTaskFromEmptySprintBacklog() {
        Task assignedTask = developer.getTaskFromSprintBacklog(sprintBacklog);
        assertNull(assignedTask);
        assertEquals(0, developer.getDoneTaskCount());
        assertEquals(0, developer.getScore());
    }

    @Test
    public void testMarkTaskAsValidate() {
        Task task = new Task("abc", 5);
        developer.markTaskAsValidate(task);
        assertEquals(Status.VALIDATE, task.getStatus());
    }
}