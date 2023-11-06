package com.notefy.notefyapp.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Das hier ist der TaskService. Er bildet die Schnittstelle
 * zwischen TaskController, unserer Schnittstelle zum Frontend, und der Datenbank dar.
 * Hier werden alle befehle für die Datenbank ausgeführt.
 * @author Lorin Faber
 * @version 1.0.0
 */
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * @return
     * Gibt alle Task Objekte von der
     * Datenbank zurück.
     */
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    /**
     * @param id
     * Nimmt die ID welche vom Controller gesendet wurde
     * und übergibt sie der Methode
     * @return
     * Mithilfe von der ID die wir bekommen haben suchen wir
     * den Eintrag in der Datenbank und geben diesen dann
     * wieder zurück.
     */
    public Task getTask(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.get();
    }

    /**
     * @param task
     * Wir bekommen ein Task Objekt vom Controller
     * und speichern dieses Objekt in der Datenbank.
     */
    public void newTask(Task task) {
        taskRepository.save(task);
    }

    /**
     * @param task
     * Wir bekommen ein verändertes Task Objekt vom Controller
     * und speichern dieses Objekt in der Datenbank.
     */
    public void updateTask(Task task) {
        taskRepository.save(task);
    }

    /**
     * @param id
     * Wir bekommen vom Controller eine ID
     * und benutzen diese um ein Objekt auf der Datenbank zu finden
     * und zu löschen.
     */
    public void deleteTask(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        taskRepository.delete(task.get());
    }
}
