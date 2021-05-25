package com.Marca.marca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarcaApplication {

	public static void main(String[] args) {
	    System.setProperty("server.servlet.context-path", "/practica-3");
		SpringApplication.run(MarcaApplication.class, args);
	}

}
