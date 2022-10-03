package com.biskot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.biskot")
@ComponentScan(basePackages={"com.biskot.domain","com.biskot.app","com.biskot.infra"})

public class BiskotApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiskotApiApplication.class, args);
	}

}
