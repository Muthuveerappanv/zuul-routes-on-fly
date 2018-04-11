package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

@RestController
@RefreshScope
class ServiceInstanceRestController {

	@Value("${lastName: Veerappan}")
	private String lastName;

	@RequestMapping("/actors/{actorId}")
	public Actor serviceInstancesByApplicationName(@PathVariable Integer actorId) {
		return new Actor(actorId, "Muthu", lastName, LocalDateTime.now());
	}
}
