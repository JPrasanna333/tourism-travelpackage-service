package com.travelpackage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelpackage.model.TravelPackage;
import com.travelpackage.repository.ITravelPackageRepository;

@Service
public class TravelPackageImpl implements ITravelPackageService {
	ITravelPackageRepository travelPackageRepository;

	@Autowired
	public void setTravelPackageRepository(ITravelPackageRepository travelPackageRepository) {
		this.travelPackageRepository = travelPackageRepository;
	}

	@Override
	public TravelPackage addTravelPackage(TravelPackage travelPackage) {
		return travelPackageRepository.save(travelPackage);

	}

	@Override
	public void updateTravelPackage(TravelPackage travelPackage) {
		travelPackageRepository.save(travelPackage);

	}

	@Override
	public void DeleteTravelPackage(int travelPackageId) {
		travelPackageRepository.deleteById(travelPackageId);

	}
	@Override
	public List<TravelPackage> getAllPackages() {
		return travelPackageRepository.findAll();
	}
	@Override
	public TravelPackage getPackageByid(int packageId) {
		return travelPackageRepository.findById(packageId).get();
	}

	@Override
	public List<TravelPackage> getPackageByLocation(String location) {
		return travelPackageRepository.findByLocation(location);
	}

	@Override
	public List<TravelPackage> getPackageByPriority(String priority) {
		return travelPackageRepository.findByPriority(priority);
	}

	@Override
	public List<TravelPackage> getPackageByStatus(String status) {
		return travelPackageRepository.findByStatus(status);
	}

	

	

}
