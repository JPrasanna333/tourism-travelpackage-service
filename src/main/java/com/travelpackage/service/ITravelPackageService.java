package com.travelpackage.service;

import java.util.List;

import com.travelpackage.exceptions.TravelPackageNotFoundException;
import com.travelpackage.model.Priority;
import com.travelpackage.model.Status;
import com.travelpackage.model.Task;
import com.travelpackage.model.TravelPackage;

/**
 * @author PrasannaJ
 *
 */
public interface ITravelPackageService {
	// calling task crud method
	Task addTask(Task task, int packageId, int agentId) ;

	String updateTask(Task task);

	String deleteTask(Integer taskId);

	// TravelPackage methods
	TravelPackage addTravelPackage(TravelPackage travelPackage);

	public TravelPackage updateTravelPackage(TravelPackage travelPackage);

	public void deleteTravelPackage(int travelPackageId) ;

	List<TravelPackage> getAllPackages();

	TravelPackage getPackageByid(int packageId);

	List<TravelPackage> getPackageByLocation(String location);

	List<TravelPackage> getPackageByPriority(Priority priority) ;

	List<TravelPackage> getPackageByStatus(Status status) ;

	List<TravelPackage> getPackageByName(String name);

	List<TravelPackage> getPackageByOwner(String owner);

	// TaskService other methods
	Task getTaskById(int taskId);

	List<Task> getAllTask();

	List<Task> getTaskByName(String taskName);

	List<Task> getTaskByOwner(String owner);

	List<Task> getTaskByCategory(String category);

	List<Task> getTaskByPriority(Priority priority);

	List<Task> getTaskByStatus(Status status);

}
