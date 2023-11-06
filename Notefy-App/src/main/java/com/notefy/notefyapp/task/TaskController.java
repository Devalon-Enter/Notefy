package com.notefy.notefyapp.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Hier befindet sich unser TaskController. Die Schnittstelle zwischen dem
 * Frontend befindet sich hier. Ausserdem findet hier die ganze Logik der Applikation statt.
 * @author Lorin Faber
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    public final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * @return
     * Gibt uns eine Liste von allen derzeit existierenden Daten
     * auf der Datenbank zurück.
     */
    @GetMapping
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    /**
     * @param id
     * Wir benutzen die id dazu ein einziges spezifisches Objekt von der
     * Datenbank zu bekommen.
     * @return
     * Falls das Objekt mit der dazugehörigen id gefunden wurde, wird
     * dieses zurückgegeben.
     * @throws IOException
     * Falls das Objekt mit der jeweiligen id nicht existiert, dann wird
     * eine IOException generiert.
     */
    @GetMapping("{id}")
    public Task getTask(@PathVariable Long id) throws IOException {
        Task task = taskService.getTask(id);
        if(task == null) {
            throw new IOException();
        }
        return task;
    }

    /**
     * @param task
     * Wenn wir einen neuen Task auf die Datenbank schreiben wolllen,
     * dann nehmen wir dafür den Task der uns mitgeschickt wurde aus dem
     * Frontend.
     */
    @PostMapping
    public void newTask(@RequestBody Task task) {
        taskService.newTask(task);
    }

    /**
     * @param id
     * Die id wird dazu verwendet, um das zu Updatende Objekt aus der
     * Datenbank zu holen. Dazu verwenden wir die Pfadvariable die wir hier mitgeben.
     * @param task
     * Der Task wurde im Frontend bereits angepasst und wird hier in diesem Parameter mitgegeben.
     * @throws IOException
     * Falls der zurückgegebene Task aus der Datenbank null wäre oder nicht existiert,
     * sollte eine IOException ausgegeben werden.
     */
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

    /**
     * @param id
     * Wir geben die id des zu löschenden Objektes mit.
     * @throws IOException
     * Falls das erhaltene Objekt von der Datenbank null ist oder nicht existiert, wird
     * eine IOException ausgegeben.
     */
    @DeleteMapping("{id}")
    public void deleteTask(@PathVariable Long id) throws IOException {
        Task exTask = taskService.getTask(id);
        if(exTask == null) {
            throw new IOException("task does not exist with id: " + id);
        }

        taskService.deleteTask(id);
        System.out.println("You deleted Task with id: " + id);
    }
}
