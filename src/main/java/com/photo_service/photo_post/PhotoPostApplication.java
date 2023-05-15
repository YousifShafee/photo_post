package com.photo_service.photo_post;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.photo_service.photo_post.repository")
@EntityScan("com.photo_service.photo_post.model")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class PhotoPostApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoPostApplication.class, args);
	}

}
