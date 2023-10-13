package com.notefy.notefyapp.task;



import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Task {

    @Id
    @SequenceGenerator(
            name = "notes_sequence",
            sequenceName = "notes_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "notes_sequence"
    )
    private Long id;
    private String title;
    private  PriorityType priority;
    private boolean done;
    private LocalDate createDate;
    private LocalDate dueDate;
    private String description;

    public Task () {

    }

    public Task(Long id, String title, PriorityType priority, boolean done, LocalDate createDate, LocalDate dueDate, String description) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.done = done;
        this.createDate = createDate;
        this.dueDate = dueDate;
        this.description = description;
    }

    public Task(String title, PriorityType priority, boolean done, LocalDate createDate, LocalDate dueDate, String description) {
        this.title = title;
        this.priority = priority;
        this.done = done;
        this.createDate = createDate;
        this.dueDate = dueDate;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PriorityType getPriority() {
        return priority;
    }

    public void setPriority(PriorityType priority) {
        this.priority = priority;
    }

    public boolean getDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", priority='" + priority + '\'' +
                ", done=" + done +
                ", createDate=" + createDate +
                ", dueDate=" + dueDate +
                ", desc=" + description +
                '}';
    }
}
