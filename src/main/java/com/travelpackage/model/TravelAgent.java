/**

 * 
 */
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

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
public class TravelAgent {
	@Id
	@GeneratedValue(generator = "agent_id", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "agent_id", sequenceName = "agent_seq",initialValue = 1,allocationSize = 1)
	private Integer agentId;
	private String agentName;
	private String owner;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	@Enumerated(EnumType.STRING)
	private Priority priority;
	@Enumerated(EnumType.STRING)
	private Status status;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "agent_id")// this creates the agent_id column in many side(Package)
	private Set<TravelPackage> travelPackages;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "agent_id")
	private Set<Task> Tasks;

}
