package com.aathasri.splitly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableJpaRepositories("com.aathasri.splitly.repository")
public class SplitlyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SplitlyApplication.class, args);
	}

}
