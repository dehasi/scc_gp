package me.dehasi.contracts.sub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SubServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubServiceApplication.class, args);
	}
}
