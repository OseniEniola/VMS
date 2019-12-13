package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloDocker {

	@RequestMapping("/hello/docker")
	public String display() {
		return "Docker file ";
	}
}
