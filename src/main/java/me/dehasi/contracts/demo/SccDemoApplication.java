package me.dehasi.contracts.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SccDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SccDemoApplication.class, args);
	}
}
