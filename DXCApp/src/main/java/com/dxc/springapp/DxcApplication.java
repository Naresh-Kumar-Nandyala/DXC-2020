package com.dxc.springapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DxcApplication {

	public static void main(String[] args) {
		SpringApplication.run(DxcApplication.class, args);
	}

}