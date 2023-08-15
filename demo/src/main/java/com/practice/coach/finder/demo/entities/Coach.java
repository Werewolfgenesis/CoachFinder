package com.practice.coach.finder.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Coaches")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Coach {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;
	

	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;
	

	@Column(name = "HOURLY_RATE", nullable = false)
	private Double rate;
	
	@ManyToMany( cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(
			  name = "coach_areas", 
			  joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"), 
			  inverseJoinColumns = @JoinColumn(name = "code", referencedColumnName = "code"))
	private List<Area> areas;
}
