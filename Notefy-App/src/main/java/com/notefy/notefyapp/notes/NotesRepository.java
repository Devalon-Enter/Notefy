package com.notefy.notefyapp.notes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends
        JpaRepository<Notes, Long> {

}
