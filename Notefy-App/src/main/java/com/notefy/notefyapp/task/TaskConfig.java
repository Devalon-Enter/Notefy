package com.notefy.notefyapp.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static com.notefy.notefyapp.task.PriorityType.HIGH;
import static com.notefy.notefyapp.task.PriorityType.LOW;
import static java.util.Calendar.*;

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
                    LocalDate.of(2023, SEPTEMBER, 23)
            );

            Task n2 = new Task(
                    "Update Database",
                    LOW,
                    false,
                    LocalDate.of(2023, SEPTEMBER, 21),
                    LocalDate.of(2023, SEPTEMBER, 25)
            );

            repository.saveAll(
                    List.of(n1, n2)
            );
        };
    }
}
