package com.example.jwt_database_interaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.jwt_database_interaction.repo")

public class JwtDatabaseInteractionApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtDatabaseInteractionApplication.class, args);
	}

}
