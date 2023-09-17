package com.example.todoapp.Controllers;

import com.example.todoapp.Models.Task;
import com.example.todoapp.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(path = "/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping(path = "/tasks/{taskId}")
    public Task getTaskById(@PathVariable Long taskId) {
        return taskService.getTaskById(taskId);
    }

    /**
     * POST: http://localhost:8080/api/tasks?taskId=1
     * @param taskId
     * @param taskObject
     * @return
     */
    @PostMapping(path = "/tasks") //need both the taskObject and taskId to create a task
    public Task createTask(@RequestParam Long taskId, @RequestBody Task taskObject) {
        return taskService.createTask(taskObject, taskId);
    }


    /**
     * PUT: http://localhost:8080/api/tasks/1
     * passing the taskObject as a separate argument
     * @param taskId
     * @param taskObject
     * @return model Task with updated changes
     */
    @PutMapping(path = "/tasks/{taskId}")
    public Task updateTask(@PathVariable Long taskId, @RequestBody Task taskObject) {
        return taskService.updateTask(taskObject, taskId);
    }

    /**
     * DELETE: http://localhost:8080/api/tasks/1
     * @param taskId
     * @return ResponseEntity that allows developer to access status codes, headers,
     * and response body.
     */
    @DeleteMapping(path = "/tasks/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable Long taskId) {
        return taskService.deleteTask(taskId);
    }

}
