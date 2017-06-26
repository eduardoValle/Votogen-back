package org.develop.votogen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VotogenApplication {
	public static void main(String[] args) {
		SpringApplication.run(VotogenApplication.class, args);
		System.out.println("Server started!!");
	}
}