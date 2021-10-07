package com.travelpackage.service;

import java.util.List;

import com.travelpackage.model.TravelPackage;

public interface ITravelPackageService {
	TravelPackage addTravelPackage(TravelPackage travelPackage);

	void updateTravelPackage(TravelPackage travelPackage);

	void DeleteTravelPackage(int travelPackageId);

	List<TravelPackage> getAllPackages();

	TravelPackage getPackageByid(int packageId);

	List<TravelPackage> getPackageByLocation(String location);

	List<TravelPackage> getPackageByPriority(String priority);

	List<TravelPackage> getPackageByStatus(String status);

}
