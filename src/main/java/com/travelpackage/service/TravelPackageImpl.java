package com.travelpackage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.travelpackage.model.Priority;
import com.travelpackage.model.Status;
import com.travelpackage.model.Task;
import com.travelpackage.model.TravelPackage;
import com.travelpackage.repository.ITravelPackageRepository;

/**
 * @author PrasannaJ
 *
 */
@Service
public class TravelPackageImpl implements ITravelPackageService {
	ITravelPackageRepository travelPackageRepository;

	@Autowired
	public void setTravelPackageRepository(ITravelPackageRepository travelPackageRepository) {
		this.travelPackageRepository = travelPackageRepository;
	}

	private RestTemplate restTemplate;

	@Autowired
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public static final String BASEURL = "http://localhost:8083/task-api";

	@Override

	public Task addTask(Task task) {
		String url = BASEURL + "/tasks";
		ResponseEntity<Task> addedTask = restTemplate.postForEntity(url, task, Task.class);
		return addedTask.getBody();
	}

	@Override
	public String updateTask(Task task) {
		String url = BASEURL + "/tasks";
		restTemplate.put(url, task);
		return "Task is updated";

	}

	@Override
	public String deleteTask(Integer taskId) {
		String url = BASEURL + "/tasks/task-id/" + taskId;
		restTemplate.delete(url, taskId);
		return "task is updated";

	}

	@Override
	public TravelPackage addTravelPackage(TravelPackage travelPackage) {
		return travelPackageRepository.save(travelPackage);

	}

	@Override
	public TravelPackage updateTravelPackage(TravelPackage travelPackage) {
		return travelPackageRepository.save(travelPackage);

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
	public List<TravelPackage> getPackageByPriority(Priority priority) {
		return travelPackageRepository.findByPriority(priority);
	}

	@Override
	public List<TravelPackage> getPackageByStatus(Status status) {
		return travelPackageRepository.findByStatus(status);
	}

	@Override
	public List<TravelPackage> getPackageByName(String name) {
		return travelPackageRepository.findByPackageName(name);
	}

	@Override
	public List<TravelPackage> getPackageByOwner(String owner) {
		return travelPackageRepository.findByOwner(owner);
	}

}
