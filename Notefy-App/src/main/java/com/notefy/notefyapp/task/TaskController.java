package com.notefy.notefyapp.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class NotesController {

    public final NotesService notesService;

    @Autowired
    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    // Get just one note by using the ID of the Object
    @GetMapping("/api/v1/note")
    public Optional<Notes> getNote(Long id) {
        return notesService.getNote(id);
    }

    // Get all the notes saved on the DB
    @GetMapping("/api/v1/notes")
    public List<Notes> getNotes() {
        return notesService.getNotes();
    }

    // Create a new note on the DB
    @PostMapping("/api/v1/new/note")
    public void newNote(@RequestBody Notes note) {
        notesService.addNewNote(note);
    }

    @PutMapping("/api/v1/note/{id}")
    public void updateNote(Long id) {
        notesService.updateNote(id);
    }

}
