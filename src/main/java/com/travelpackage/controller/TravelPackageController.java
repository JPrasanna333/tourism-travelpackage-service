package com.travelpackage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelpackage.model.TravelPackage;
import com.travelpackage.service.ITravelPackageService;

@RestController
@RequestMapping("packages-service")
public class TravelPackageController {
	ITravelPackageService travelPackageService;

	@Autowired
	public void setTravelPackageService(ITravelPackageService travelPackageService) {
		this.travelPackageService = travelPackageService;
	}

	@PostMapping("/packages")
	ResponseEntity<TravelPackage> addTravelPackage(@RequestBody TravelPackage travelPackage) {
		TravelPackage addPackage = travelPackageService.addTravelPackage(travelPackage);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "package is added");
		return ResponseEntity.ok().headers(headers).body(addPackage);

	}

	@PutMapping("/packages")
	ResponseEntity<Void> updateTravelPackage(@RequestBody TravelPackage travelPackage) {
		travelPackageService.updateTravelPackage(travelPackage);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "package is updated");
		return ResponseEntity.ok().headers(headers).build();

	}

	@DeleteMapping("/packages/{packageId}")

	ResponseEntity<String> DeleteTravelPackage(int travelPackageId) {
		travelPackageService.DeleteTravelPackage(travelPackageId);
		return ResponseEntity.status(HttpStatus.OK).body("deleted succcessfully");

	}

	@GetMapping("/packages/id/{packageId}")
	ResponseEntity<TravelPackage> getPackageByid(@PathVariable("packageId") int packageId) {
		TravelPackage packageById = travelPackageService.getPackageByid(packageId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Got one package by PackageId");
		return ResponseEntity.ok().headers(headers).body(packageById);

	}

	@GetMapping("/packages")
	ResponseEntity<List<TravelPackage>> getAllPackages() {
		List<TravelPackage> packageList = travelPackageService.getAllPackages();
		return ResponseEntity.ok().body(packageList);

	}

	@GetMapping("/packages/location/{location}")
	ResponseEntity<List<TravelPackage>> getPackageByLocation(@PathVariable("location") String location) {
		List<TravelPackage> packageByLocation = travelPackageService.getPackageByLocation(location);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Got List of package by location");
		return ResponseEntity.ok().headers(headers).body(packageByLocation);

	}

	@GetMapping("packages/priority/{priority}")
	ResponseEntity<List<TravelPackage>> getPackageByPriority(@PathVariable("priority") String priority) {
		List<TravelPackage> packageByPriority = travelPackageService.getPackageByPriority(priority);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Got Package list by priority");
		return ResponseEntity.ok().headers(headers).body(packageByPriority);

	}

	@GetMapping("/packages/status/{status}")
	ResponseEntity<List<TravelPackage>> getPackageByStatus(@PathVariable("status") String status) {
		List<TravelPackage> packageByStatus = travelPackageService.getPackageByStatus(status);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Got Package list by status");
		return ResponseEntity.ok().headers(headers).body(packageByStatus);

	}

}
