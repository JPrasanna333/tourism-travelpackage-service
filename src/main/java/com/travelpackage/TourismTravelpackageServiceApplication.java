package com.travelpackage;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.travelpackage.model.Priority;
import com.travelpackage.model.Status;
import com.travelpackage.model.TravelPackage;
import com.travelpackage.service.ITravelPackageService;

@SpringBootApplication
public class TourismTravelpackageServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TourismTravelpackageServiceApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Autowired
	ITravelPackageService packageService;

	@Override
	public void run(String... args) throws Exception {
		TravelPackage packages = new TravelPackage("Goa package", "Prasanna", LocalDateTime.of(2021, 5, 16, 7, 45, 45),
				LocalDateTime.of(2021, 5, 18, 6, 40, 45), "Goa", Priority.HIGH, Status.DEFINED);
		// packageService.addTravelPackage(packages);

	}

}
