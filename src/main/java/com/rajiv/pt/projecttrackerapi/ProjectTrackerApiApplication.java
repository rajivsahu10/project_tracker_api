package com.rajiv.pt.projecttrackerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ProjectTrackerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectTrackerApiApplication.class, args);
	}
}
