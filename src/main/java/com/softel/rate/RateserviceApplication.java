package com.softel.rate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RateserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RateserviceApplication.class, args);
	}

}
