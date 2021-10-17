package com.travelpackage.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Task {

	@Id
	private Integer taskId;
	private String taskName;
	private String category;
	private String owner;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private double duration;
	@Enumerated(EnumType.STRING)
	@Column(length = 8)
	private Priority priority;
	@Enumerated(EnumType.STRING)
	@Column(length = 8)
	private Status status;
	
	@ManyToOne
	@JoinColumn(name = "agent_id")
	private TravelAgent travelAgent;
	
	@ManyToOne
	@JoinColumn(name = "package_id")
	private TravelPackage travelPackage;

	@Override
	public String toString() {
		return "Task [taskName=" + taskName + ", category=" + category + ", owner=" + owner + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", duration=" + duration + ", priority=" + priority + ", status=" + status
				+ "]";
	}
	
	
	

}
