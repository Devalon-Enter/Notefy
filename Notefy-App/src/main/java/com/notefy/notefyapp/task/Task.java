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
    private String priority;
    private boolean done;
    private LocalDate createDate;
    private LocalDate dueDate;

    public Task () {

    }

    public Task(Long id, String title, String priority, boolean done, LocalDate createDate, LocalDate dueDate) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.done = done;
        this.createDate = createDate;
        this.dueDate = dueDate;
    }

    public Task(String title, String priority, boolean done, LocalDate createDate, LocalDate dueDate) {
        this.title = title;
        this.priority = priority;
        this.done = done;
        this.createDate = createDate;
        this.dueDate = dueDate;
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

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public boolean isDone() {
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

    @Override
    public String toString() {
        return "Notes{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", priority='" + priority + '\'' +
                ", done=" + done +
                ", createDate=" + createDate +
                ", dueDate=" + dueDate +
                '}';
    }
}
