package com.photo_service.photo_post;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class PhotoPostApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoPostApplication.class, args);
	}

}
