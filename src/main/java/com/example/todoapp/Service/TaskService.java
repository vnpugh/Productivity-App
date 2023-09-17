package com.example.todoapp.Service;

import com.example.todoapp.Enums.TaskStatus;
import com.example.todoapp.Models.Task;
import com.example.todoapp.Repository.TaskListRepository;
import com.example.todoapp.Repository.TaskRepository;
import com.example.todoapp.Enums.TaskPriority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;


@Service
public class TaskService {

    private TaskRepository taskRepository;
    private TaskListRepository taskListRepository;
    private UserService userService;

    /**
     * Sets the TaskRepository instance for this TaskManager.
     * This method is used for dependency injection to provide the necessary service implementation.
     * @param taskRepository The TaskRepository instance to be injected.
     */
    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * Sets the TaskListRepository instance for this TaskManager.
     * This method is used for dependency injection to provide the necessary service implementation.
     * @param taskListRepository The TaskListRepository instance to be injected.
     */
    @Autowired
    public void setTaskListRepository(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    /**
     * Sets the UserService instance for this TaskManager.
     * This method is used for dependency injection to provide the necessary service implementation.
     * @param userService The UserService instance to be injected.
     */
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * GET ALL TASKS, gets all tasks for a specific user.
     * @return a list of all tasks
     */
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * GET ONE TASK, gets a task by its ID.
     * @param taskId taskId
     * @return a Task object
     */
    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId).orElseThrow();
    }

   /**
    * CREATE TASK, creates a task for a specific user.
    * @param taskObject taskObject
    * @param taskId
    * @return a Task object
    */
    public Task createTask(Task taskObject, Long taskId) {
        taskObject.setTaskList(taskListRepository.findById(taskObject.getTaskList().getTaskListId()).orElseThrow());
        taskObject.setUser(userService.getCurrentUser());
        // Set the default priority and status for the task
        taskObject.setTaskPriority(TaskPriority.LOW); // Set the default priority here
        taskObject.setTaskStatus(TaskStatus.NOT_STARTED); // Set the default status here

        // Set the default due date for the task
        if (taskObject.getDueDate() == null) {
            taskObject.setDueDate(LocalDate.now());
        }
        return taskRepository.save(taskObject);
    }





    /**
     * UPDATE TASK, updates a task for a specific user.
     * @param taskId taskId
     * @param taskObject taskObject
     * @return a Task object
     */

    public Task updateTask(Task taskObject, Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow();
        task.setTitle(taskObject.getTitle());
        task.setDescription(taskObject.getDescription());
        task.setTaskPriority(taskObject.getTaskPriority());
        task.setDueDate(taskObject.getDueDate());
        task.setTaskStatus(taskObject.getTaskStatus());
        task.setNotes(taskObject.getNotes());
        task.setTaskList(taskListRepository.findById(taskObject.getTaskList().getTaskListId()).orElseThrow());
        return taskRepository.save(task);
    }


    /**
     * DELETE TASK, deletes a task for a specific user.
     * @param taskId taskId
     * @return a Task object
     */
    public ResponseEntity<?> deleteTask(Long taskId){
            Task task = taskRepository.findById(taskId).orElseThrow();
            taskRepository.delete(task);
            return ResponseEntity.ok().build();

        }



    }


