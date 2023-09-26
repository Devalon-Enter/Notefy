package com.notefy.notefyapp.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getNotes() {
        return taskRepository.findAll();
    }

    public void addNewNote(Task task) {
        System.out.println(task);
    }
}
