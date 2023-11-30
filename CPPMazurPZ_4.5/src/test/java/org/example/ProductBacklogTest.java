package org.example;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class ProductBacklogTest extends TestCase {
    ProductBacklog productBacklog = new ProductBacklog();
    Task task1 = new Task("abc", 20);
    Task task2 = new Task("abd", 40);
    Task task3 = new Task("abe", 100);

    @Test
    public void testAddTask() {
        productBacklog.addTask(task1);
        assertEquals(1, productBacklog.getTaskQueue().size());
    }

    @Test
    public void testDeleteTask() {
        productBacklog.addTask(task1);
        productBacklog.addTask(task2);
        assertEquals(2, productBacklog.getTaskQueue().size());
        productBacklog.deleteTask(task1);
        assertEquals(1, productBacklog.getTaskQueue().size());
        assertFalse(productBacklog.getTaskQueue().contains(task1));
        assertTrue(productBacklog.getTaskQueue().contains(task2));
    }

    @Test
    public void testSwapTasks() {
        productBacklog.addTask(task1);
        productBacklog.addTask(task2);
        productBacklog.addTask(task3);
        productBacklog.printProductBacklog();
        productBacklog.swapTasks(task1, task3);
        productBacklog.printProductBacklog();
        assertEquals(task3, productBacklog.getTaskQueue().peek());
    }
}