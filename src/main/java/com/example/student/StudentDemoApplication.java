package com.example.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class StudentDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentDemoApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public CommandLineRunner dataLoader(StudentRepo repo) {
		return args -> {
			repo.save(new Student(1L, "Alice", "example@example.com", "0000", "123 Alice St", "Freshman", "Math"));
			repo.save(new Student(2L, "Bob", "example@example.com", "0000", "123 Bob St", "Sophomore", "English"));
			repo.save(new Student(3L, "Charlie", "example@example.com", "0000", "123 Charlie St", "Junior", "History"));
		};
	}
}
