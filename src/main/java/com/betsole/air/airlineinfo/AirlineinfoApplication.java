package com.betsole.air.airlineinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages={"com.betsole.air.info"})
@SpringBootApplication
public class AirlineinfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlineinfoApplication.class, args);
	}
}
