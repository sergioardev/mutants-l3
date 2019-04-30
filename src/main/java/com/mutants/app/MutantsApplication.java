package com.mutants.app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@ComponentScan
public class MutantsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MutantsApplication.class, args);
	}

}