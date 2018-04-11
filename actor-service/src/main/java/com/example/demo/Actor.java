package com.example.demo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
public @Data class Actor {
	private Integer actorId;
	private String firstName;
	private String lastName;
	private LocalDateTime lastUpdated;

}
