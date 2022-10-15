package com.irr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;



@SpringBootApplication
@EnableScheduling
public class Irr1Application {

	
	public static void main(String[] args) {
		SpringApplication.run(Irr1Application.class, args);
	}

}
