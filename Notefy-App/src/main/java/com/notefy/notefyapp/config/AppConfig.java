package com.notefy.notefyapp.config;

import com.notefy.notefyapp.task.Task;
import com.notefy.notefyapp.task.TaskRepository;
import com.notefy.notefyapp.user.User;
import com.notefy.notefyapp.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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
@Profile("prod")
public class AppConfig {
    @Bean
    CommandLineRunner commandLineRunner(TaskRepository taskRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
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

            taskRepository.saveAll(
                    List.of(n1, n2)
            );

            User u1 = new User(
                    "Lorin",
                    "Lorin",
                    "Faber",
                    "CoolGuy",
                    Set.of("USER", "ADMIN"),
                    passwordEncoder.encode("myAss")
            );

            User u2 = new User(
                    "Mark",
                    "Mark",
                    "Bigler",
                    "CoolTeacher",
                    Set.of("USER"),
                    passwordEncoder.encode("igSchiesseSeUfDeMond!")
            );

            userRepository.saveAll(
                    List.of(u1, u2)
            );
        };
    }
}
