package com.example.DotApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DotApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DotApiApplication.class, args);
		System.out.println("Hello World1234");
	}

}
