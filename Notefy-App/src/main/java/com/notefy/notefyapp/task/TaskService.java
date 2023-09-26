package com.notefy.notefyapp.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotesService {

    private final NotesRepository notesRepository;

    @Autowired
    public NotesService(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    public Optional<Notes> getNote(Long id) {
        return notesRepository.findById(id);
    }

    public List<Notes> getNotes() {
        return notesRepository.findAll();
    }

    public void addNewNote(Notes note) {
        notesRepository.save(note);
        System.out.println("Saved on DB:" + note);
    }

    public void updateNote(Long id) {

    }

}
