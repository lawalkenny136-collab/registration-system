package com.amigoscode.registrationsystem;

import com.amigoscode.registrationsystem.book.BookRepository;
import com.amigoscode.registrationsystem.book.Books;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class RegistrationsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationsystemApplication.class, args);
	}

}
