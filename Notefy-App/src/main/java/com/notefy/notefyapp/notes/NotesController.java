package com.notefy.notefyapp.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")
public class NotesController {

    public final NotesService notesService;

    @Autowired
    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping
    public List<Notes> getNotes() {
        return notesService.getNotes();
    }

    @PostMapping
    public void newNote(@RequestBody Notes note) {
        notesService.addNewNote(note);
    }
}
