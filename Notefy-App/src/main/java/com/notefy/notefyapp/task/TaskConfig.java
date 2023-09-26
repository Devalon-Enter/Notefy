package com.notefy.notefyapp.notes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.util.Calendar.*;

@Configuration
public class NotesConfig {
    @Bean
    CommandLineRunner commandLineRunner(NotesRepository repository) {
        return args -> {
            Notes n1 = new Notes(
                    "Create Notes",
                    LocalDate.of(2023, SEPTEMBER, 21),
                    LocalDate.of(2023, SEPTEMBER, 23)
            );

            Notes n2 = new Notes(
                    "Update Database",
                    LocalDate.of(2023, SEPTEMBER, 21),
                    LocalDate.of(2023, SEPTEMBER, 25)
            );

            repository.saveAll(
                    List.of(n1, n2)
            );
        };
    }
}
