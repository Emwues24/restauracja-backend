package com.restauracja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RestauracjaApplication {

	public static int nextID=0;

	public static void main(String[] args) {

		SpringApplication.run(RestauracjaApplication.class, args);
	}

	@GetMapping
	public String test() {
		return "Restauracja xpp";
	}

}
