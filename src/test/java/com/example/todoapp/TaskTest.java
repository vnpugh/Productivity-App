package com.example.todoapp;

import com.example.todoapp.Controllers.TaskController;
import com.example.todoapp.Enums.TaskPriority;
import com.example.todoapp.Enums.TaskStatus;
import com.example.todoapp.Models.Task;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TaskTest {

    /** Test the Task class getters and the enums */
    @Test
    public void testTask() {
        Task task = new Task("title", "description", LocalDate.now(), TaskPriority.LOW, TaskStatus.IN_PROGRESS, "notes");
        assertEquals("title", task.getTitle());
        assertEquals("description", task.getDescription());
        assertEquals(LocalDate.now(), task.getDueDate());
        assertEquals(TaskPriority.LOW, task.getTaskPriority());
        assertEquals(TaskStatus.IN_PROGRESS, task.getTaskStatus());
        assertEquals("notes", task.getNotes());
        
        }


}
