package com.notefy.notefyapp.notes;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class NotesService {
    public List<Notes> getNotes() {
        return List.of(
                new Notes(
                        1L,
                        "Create Notes",
                        LocalDate.of(2023, Month.SEPTEMBER, 21),
                        LocalDate.of(2023, Month.SEPTEMBER, 23)
                )
        );
    }
}
