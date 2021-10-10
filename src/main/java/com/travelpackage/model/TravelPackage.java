package com.travelpackage.model;

import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author PrasannaJ
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class TravelPackage {
	@Id
	@GeneratedValue(generator = "package_id", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "package_id", sequenceName = "package_seq", initialValue = 1, allocationSize = 1)
	private Integer packageId;
	private String packageName;
	private String owner;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private String location;
	@Enumerated(EnumType.STRING)
	private Priority priority;
	@Enumerated(EnumType.STRING)
	private Status status;

	@ManyToOne
	@JoinColumn(name = "agent_id") // this doesn't creates the column of the instance variable
	@JsonIgnore
	private TravelAgent travelAgent;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name = "package_id")
	private Set<Task> Tasks;

	public TravelPackage(String packageName, String owner, LocalDateTime startDate, LocalDateTime endDate,
			String location, Priority priority, Status status) {
		super();
		this.packageName = packageName;
		this.owner = owner;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
		this.priority = priority;
		this.status = status;
	}

}
