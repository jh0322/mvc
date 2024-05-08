package com.example.mvc04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class Mvc04Application {

	public static void main(String[] args) {
		SpringApplication.run(Mvc04Application.class, args);
	}

}
