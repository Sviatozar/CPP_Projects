package org.example;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskTest {
    @Test
    public void testCreateTaskWithDefaultStatus() {
        Task task = new Task("Sample Task", 8);
        assertEquals(Status.TO_DO, task.getStatus());
    }

    @Test
    public void testAutoIncrementId() {
        Task task1 = new Task("Task 1", 8);
        Task task2 = new Task("Task 2", 13);

        assertEquals(task1.getId() + 1, task2.getId());
    }

    @Test
    public void testCreateTaskWithParametrizedConstructor() {
        Task task = new Task("Sample Task", 8);
        assertEquals(8, task.getStoryPoints());
    }

    @Test
    public void testCreateTaskWithRandomPriority() {
        Task task1 = new Task("Task 1", 8);
        Task task2 = new Task("Task 2", 13);

        Assert.assertNotEquals(task1.getPriority(), task2.getPriority());
    }

    @Test
    public void testSetInvalidStoryPoints() {
        assertThrows(IllegalArgumentException.class, () -> new Task("Invalid Task", 7));
    }

    @Test
    public void testSetStatus() {
        Task task = new Task("Task", 5);

        task.setStatus(Status.IN_PROGRESS);
        assertEquals(Status.IN_PROGRESS, task.getStatus());

        task.setStatus(Status.VALIDATE);
        assertEquals(Status.VALIDATE, task.getStatus());

        task.setStatus(Status.DONE);
        assertEquals(Status.DONE, task.getStatus());
    }
}