package com.test.emplyeeSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EmployeeMenegmentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMenegmentSystemApplication.class, args);
	}

}
