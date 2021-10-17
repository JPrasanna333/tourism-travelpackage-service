package com.travelpackage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelpackage.model.Priority;
import com.travelpackage.model.Status;
import com.travelpackage.model.TravelPackage;

/**
 * @author PrasannaJ
 *
 */

@Repository
public interface ITravelPackageRepository extends JpaRepository<TravelPackage, Integer> {

	List<TravelPackage> findByLocation(String location);

	List<TravelPackage> findByPriority(Priority priority);

	List<TravelPackage> findByStatus(Status status);

	List<TravelPackage> findByPackageName(String name);

	List<TravelPackage> findByOwner(String owner);

}
