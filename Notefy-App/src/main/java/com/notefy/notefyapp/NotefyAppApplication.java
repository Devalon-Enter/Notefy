package com.notefy.notefyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class NotefyAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotefyAppApplication.class, args);
    }
}
