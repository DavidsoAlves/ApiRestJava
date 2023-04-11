package com.api.productcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class ProductControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductControlApplication.class, args);
	}

	@GetMapping("/")
	public String index(){
			return "API REST - PRODUCT CONTROL!";
	}
}
