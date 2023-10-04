package com.notefy.notefyapp.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        System.out.println("found items");
        return taskRepository.findAll();
    }

    public Task getTask(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.get();
    }

    public void newTask(Task task) {
        System.out.println("You saved something on the DB: " + task);
        taskRepository.save(task);
    }

    public void updateTask(Task task) {
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        taskRepository.delete(task.get());
    }
}
