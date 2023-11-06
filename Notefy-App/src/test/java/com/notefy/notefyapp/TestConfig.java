package com.notefy.notefyapp;

import com.notefy.notefyapp.task.TaskRepository;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {
    @Bean
    public TaskRepository taskRepository() {
        return Mockito.mock(TaskRepository.class);
    }
}
