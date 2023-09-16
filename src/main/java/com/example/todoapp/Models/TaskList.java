package com.example.todoapp.Models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "task_list")
public class TaskList {

        @Id
        @Column
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long taskListId;
        @Column
        private String listName;
        @Column
        private String category;

        public TaskList() {
        }

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        @OneToMany(mappedBy = "taskList")
        private List<Task> tasks;

        public TaskList(String listName, String category) {
                this.listName = listName;
                this.category = category;
        }

    public Long getTaskListId() {
        return taskListId;
    }

    public void setTaskListId(Long taskListId) {
        this.taskListId = taskListId;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "taskListId=" + taskListId +
                ", listName='" + listName + '\'' +
                ", category='" + category + '\'' +
                ", user=" + user +
                ", tasks=" + tasks +
                '}';
    }
}
