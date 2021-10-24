package com.travelpackage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.travelpackage.exceptions.TravelPackageNotFoundException;
import com.travelpackage.model.Priority;
import com.travelpackage.model.Status;
import com.travelpackage.model.Task;
import com.travelpackage.model.TravelAgent;
import com.travelpackage.model.TravelPackage;
import com.travelpackage.repository.ITravelPackageRepository;

/**
 * @author PrasannaJ
 *
 */
@Service
public class TravelPackageImpl implements ITravelPackageService {

	public static final String BASEURL = "http://localhost:8083/task-api/";

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

	@Override

	public Task addTask(Task task, int packageId, int agentId) throws TravelPackageNotFoundException {

		String agentUrl = "http://AGENT-SERVICE/agent-api/agents/" + agentId;
		String taskurl = BASEURL + "/tasks";

		ResponseEntity<TravelAgent> agent = restTemplate.getForEntity(agentUrl, TravelAgent.class);
		TravelAgent travelAgent = agent.getBody();

		TravelPackage travelPackage = getPackageByid(packageId);

		task.setTravelPackage(travelPackage);
		task.setTravelAgent(travelAgent);

		ResponseEntity<Task> addedTask = restTemplate.postForEntity(taskurl, task, Task.class);
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
		return "task is deleted";

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
	public void deleteTravelPackage(int travelPackageId) throws TravelPackageNotFoundException {
		if (travelPackageRepository.findById(travelPackageId).get() == null) {
			throw new TravelPackageNotFoundException("Travel Package is not found with the given id..");
		}
		travelPackageRepository.deleteById(travelPackageId);
	}

	@Override
	public List<TravelPackage> getAllPackages() {
		return travelPackageRepository.findAll();
	}

	@Override
	public TravelPackage getPackageByid(int packageId) throws TravelPackageNotFoundException {
		TravelPackage packageById = travelPackageRepository.findById(packageId).get();
		if (packageById == null) {
			throw new TravelPackageNotFoundException("Travel Package is not found with the given id..");
		}
		return packageById;
	}

	@Override
	public List<TravelPackage> getPackageByLocation(String location) throws TravelPackageNotFoundException {
		List<TravelPackage> packageByLocation = travelPackageRepository.findByLocation(location);
		if (packageByLocation.isEmpty()) {
			throw new TravelPackageNotFoundException(
					"Travel package not found with the given location.Please enter a valid location");
		}
		return packageByLocation;
	}

	@Override
	public List<TravelPackage> getPackageByPriority(Priority priority) throws TravelPackageNotFoundException {
		List<TravelPackage> packageByPriority = travelPackageRepository.findByPriority(priority);
		if (packageByPriority.isEmpty()) {
			throw new TravelPackageNotFoundException(
					"Travel package not found with the given priority .Please enter a valid priority");
		}
		return packageByPriority;
	}

	@Override
	public List<TravelPackage> getPackageByStatus(Status status) throws TravelPackageNotFoundException {
		List<TravelPackage> packageByStatus = travelPackageRepository.findByStatus(status);
		if (packageByStatus.isEmpty()) {
			throw new TravelPackageNotFoundException(
					"Travel package not found with the given status .Please enter a valid status");
		}
		return packageByStatus;
	}

	@Override
	public List<TravelPackage> getPackageByName(String name) throws TravelPackageNotFoundException {
		List<TravelPackage> packageByName = travelPackageRepository.findByPackageName(name);
		if (packageByName.isEmpty()) {
			throw new TravelPackageNotFoundException(
					"Travel package not found with the given name .Please enter a valid name");
		}
		return packageByName;
	}

	@Override
	public List<TravelPackage> getPackageByOwner(String owner) throws TravelPackageNotFoundException {
		List<TravelPackage> packageByOwner = travelPackageRepository.findByOwner(owner);
		if (packageByOwner.isEmpty()) {
			throw new TravelPackageNotFoundException(
					"Travel package not found with the given owner name .Please enter a valid owner name");
		}
		return packageByOwner;
	}

	@Override
	public Task getTaskById(int taskId) {

		String url = BASEURL + "tasks/" + taskId;
		ResponseEntity<Task> taskById = restTemplate.getForEntity(url, Task.class);
		return taskById.getBody();
	}

	@Override
	public List<Task> getAllTask() {
		String url = BASEURL + "tasks";
		ResponseEntity<List> taskList = restTemplate.getForEntity(url, List.class);
		return taskList.getBody();
	}

	@Override
	public List<Task> getTaskByName(String taskName) {
		String url = BASEURL + "tasks/task-name/" + taskName;
		ResponseEntity<List> taskByName = restTemplate.getForEntity(url, List.class);
		return taskByName.getBody();
	}

	@Override
	public List<Task> getTaskByOwner(String owner) {
		String url = BASEURL + "tasks/owner/" + owner;
		ResponseEntity<List> taskByOwner = restTemplate.getForEntity(url, List.class);
		return taskByOwner.getBody();
	}

	@Override
	public List<Task> getTaskByCategory(String category) {
		String url = BASEURL + "tasks/category/" + category;
		ResponseEntity<List> taskByCategory = restTemplate.getForEntity(url, List.class);
		return taskByCategory.getBody();
	}

	@Override
	public List<Task> getTaskByPriority(Priority priority) {
		String url = BASEURL + "tasks/priority/" + priority;
		ResponseEntity<List> taskByPriority = restTemplate.getForEntity(url, List.class);
		return taskByPriority.getBody();
	}

	@Override
	public List<Task> getTaskByStatus(Status status) {
		String url = BASEURL + "tasks/status/" + status;
		ResponseEntity<List> taskByStatus = restTemplate.getForEntity(url, List.class);
		return taskByStatus.getBody();
	}

}
