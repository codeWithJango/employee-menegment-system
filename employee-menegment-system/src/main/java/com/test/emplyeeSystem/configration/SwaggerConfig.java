package com.test.emplyeeSystem.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	@Bean
	public OpenAPI customAPi() {
		return new OpenAPI().info(new Info().title("Employee Management System").description("all cruad operation is here")
				.contact(new Contact().name("jayanta").email("jayanta@nttdata.com")).version("0.1")
				
				);

	}

}
