package com.example.devsutestcuentamovimiento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@SpringBootApplication
// habilitamos descubrimiento de microservicios
@EnableDiscoveryClient
// habilitamos transacciones en la BD
@EnableTransactionManagement
public class DevsutestcuentamovimientoApplication {

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	protected Logger logger = Logger.getLogger(com.example.devsutestcuentamovimiento.DevsutestcuentamovimientoApplication.class.getName());

	public static void main(String[] args) {
		// Default to registration server on localhost
		if (System.getProperty("registration.server.hostname") == null)
			System.setProperty("registration.server.hostname", "localhost");

		// Tell server to look for cliente-persona-server.properties or
		// cliente-persona-server.yml
		System.setProperty("spring.config.name", "cuenta-movimiento-server");

		SpringApplication.run(
				com.example.devsutestcuentamovimiento.DevsutestcuentamovimientoApplication.class, args);
	}

}
