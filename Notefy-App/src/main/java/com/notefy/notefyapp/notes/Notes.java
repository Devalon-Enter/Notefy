package com.notefy.notefyapp.notes;



import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Notes {

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
    private LocalDate fromDate;
    private LocalDate toDate;

    public Notes() {

    }

    public Notes(Long id, String title, LocalDate fromDate, LocalDate toDate) {
        this.id = id;
        this.title = title;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public Notes(String title, LocalDate fromDate, LocalDate toDate) {
        this.title = title;
        this.fromDate = fromDate;
        this.toDate = toDate;
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

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", from=" + fromDate +
                ", to=" + toDate +
                '}';
    }
}
