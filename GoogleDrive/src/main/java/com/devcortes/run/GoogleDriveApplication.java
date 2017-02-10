package com.devcortes.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan({ "com.devcortes" })
public class GoogleDriveApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoogleDriveApplication.class, args);
	}
}
