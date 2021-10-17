package com.travelpackage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


import com.travelpackage.service.ITravelPackageService;

@SpringBootApplication
@EnableEurekaClient
public class TourismTravelpackageServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TourismTravelpackageServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	ITravelPackageService packageService;

	@Override
	public void run(String... args) throws Exception {

	}

}
