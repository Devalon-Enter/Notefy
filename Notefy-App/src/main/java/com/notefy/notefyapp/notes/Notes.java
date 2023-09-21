package com.notefy.notefyapp.notes;

import java.time.LocalDate;

public class Notes {
    private long id;
    private String title;
    private LocalDate from;
    private LocalDate to;

    public Notes(long id, String title, LocalDate from, LocalDate to) {
        this.id = id;
        this.title = title;
        this.from = from;
        this.to = to;
    }

    public Notes(String title, LocalDate from, LocalDate to) {
        this.title = title;
        this.from = from;
        this.to = to;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}
