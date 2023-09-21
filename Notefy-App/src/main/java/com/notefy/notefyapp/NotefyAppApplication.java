package com.notefy.notefyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@SpringBootApplication
@RestController
public class NotefyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotefyAppApplication.class, args);
	}
}
