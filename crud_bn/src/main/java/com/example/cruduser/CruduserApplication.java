package com.example.cruduser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CruduserApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruduserApplication.class, args);
		System.out.println("Start database h2");
	}

}
