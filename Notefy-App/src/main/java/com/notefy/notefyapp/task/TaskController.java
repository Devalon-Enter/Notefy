package com.notefy.notefyapp.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    public final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("{id}")
    public Task getTask(@PathVariable Long id) throws IOException {
        Task task = taskService.getTask(id);
        if(task == null) {
            throw new IOException("task does not exist with id: " + id);
        }
        return task;
    }

    @PostMapping
    public void newTask(@RequestBody Task task) {
        taskService.newTask(task);
    }

    @PutMapping("{id}")
    public void updateTask(@PathVariable Long id, @RequestBody Task task) throws IOException {
        Task exTask = taskService.getTask(id);
        if(exTask == null) {
            throw new IOException("task does not exist with id: " + id);
        }

        exTask.setTitle(task.getTitle());
        exTask.setPriority(task.getPriority());
        exTask.setDone(task.getDone());
        exTask.setDueDate(task.getDueDate());
        exTask.setDescription(task.getDescription());

        taskService.updateTask(exTask);
    }

    @DeleteMapping("{id}")
    public void deleteNote(@PathVariable Long id) throws IOException {
        Task exTask = taskService.getTask(id);
        if(exTask == null) {
            throw new IOException("task does not exist with id: " + id);
        }

        taskService.deleteTask(id);
        System.out.println("You deleted Task with id: " + id);
    }
}
