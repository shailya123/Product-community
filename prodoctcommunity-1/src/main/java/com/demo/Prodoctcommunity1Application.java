package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
"com.demo.Controller", "com.demo.Service","com.demo.repo"})
public class Prodoctcommunity1Application {

	public static void main(String[] args) {
		SpringApplication.run(Prodoctcommunity1Application.class, args);
	}

}
