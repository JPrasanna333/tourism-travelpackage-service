package com.travelpackage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelpackage.model.TravelPackage;

@Repository
public interface ITravelPackageRepository extends JpaRepository<TravelPackage, Integer> {
	List<TravelPackage> findByLocation(String location);

	List<TravelPackage> findByPriority(String priority);

	List<TravelPackage> findByStatus(String status);

}
