package com.example.devsutestclientepersona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.logging.Logger;

@SpringBootApplication
// habilitamos descubrimiento de microservicios
@EnableDiscoveryClient
// habilitamos transacciones en la BD
@EnableTransactionManagement
public class DevsutestclientepersonaApplication {

	protected Logger logger = Logger.getLogger(DevsutestclientepersonaApplication.class.getName());

	public static void main(String[] args) {
		// Default to registration server on localhost
		if (System.getProperty("registration.server.hostname") == null)
			System.setProperty("registration.server.hostname", "localhost");

		// Tell server to look for cliente-persona-server.properties or
		// cliente-persona-server.yml
		System.setProperty("spring.config.name", "cliente-persona-server");

		SpringApplication.run(
				DevsutestclientepersonaApplication.class, args);
	}

}
