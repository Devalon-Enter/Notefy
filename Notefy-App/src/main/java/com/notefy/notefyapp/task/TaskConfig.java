package com.notefy.notefyapp.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.List;

import static com.notefy.notefyapp.task.PriorityType.HIGH;
import static com.notefy.notefyapp.task.PriorityType.LOW;
import static java.util.Calendar.*;

/**
 * Da unsere Applikation nicht durchgehend läuft, wird hier
 * jedes Mal wenn sie gestartet wird, zwei neue Objekte auf die Datenbank geschrieben.
 * Das soll uns Zeit einsparen.
 * @author Lorin Faber
 * @version 1.0.0
 */
@Configuration
public class TaskConfig {
    @Bean
    CommandLineRunner commandLineRunner(TaskRepository repository) {
        return args -> {
            Task n1 = new Task(
                    "Create Notes",
                    HIGH,
                    false,
                    LocalDate.of(2023, SEPTEMBER, 21),
                    LocalDate.of(2023, SEPTEMBER, 23),
                    "We need for some tests those notes alright?"
            );

            Task n2 = new Task(
                    "Update Database",
                    LOW,
                    false,
                    LocalDate.of(2023, SEPTEMBER, 21),
                    LocalDate.of(2023, SEPTEMBER, 25),
                    "In order for us to work, we need to be sure the DB is updated."
            );

            repository.saveAll(
                    List.of(n1, n2)
            );
        };
    }
}
