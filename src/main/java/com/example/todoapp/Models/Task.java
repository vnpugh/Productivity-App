package com.example.todoapp.Models;

import com.example.todoapp.TaskPriority;
import com.example.todoapp.TaskStatus;
import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_priority", nullable = false)
    private TaskPriority taskPriority;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_status", nullable = false)
    private TaskStatus taskStatus;

    @Column
    private String notes;

    public Task() {
    }
    @ManyToOne
    @JoinColumn(name = "task_list_id")
    private TaskList taskList;

    public Task(String title, String description, LocalDate dueDate, TaskPriority taskPriority,
                TaskStatus taskStatus, String notes) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.taskPriority = taskPriority;
        this.taskStatus = taskStatus;
        this.notes = notes;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public TaskPriority getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(TaskPriority taskPriority) {
        this.taskPriority = taskPriority;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", taskPriority=" + taskPriority +
                ", taskStatus=" + taskStatus +
                ", notes='" + notes + '\'' +
                ", taskList=" + taskList +
                '}';
    }

}
