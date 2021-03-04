package com.accolite.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.accolite.controller.ShoppingCartController;

@SpringBootApplication
@ComponentScan(basePackageClasses = ShoppingCartController.class)
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MainApplication.class);
//	    app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
	    app.run(args);
	}
}
