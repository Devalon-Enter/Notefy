package com.notefy.notefyapp.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Task> getNotes() {
        return taskService.getNotes();
    }

    @PostMapping
    public void newNote(@RequestBody Task task) {
        taskService.addNewNote(task);
    }
}
