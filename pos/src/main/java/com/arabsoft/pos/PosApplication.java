package com.arabsoft.pos;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.arabsoft.pos.modules.Category;
import com.arabsoft.pos.repositories.CategoryRepository;

@SpringBootApplication
public class PosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CategoryRepository repo) {
		return (args) -> {};
	}

}
