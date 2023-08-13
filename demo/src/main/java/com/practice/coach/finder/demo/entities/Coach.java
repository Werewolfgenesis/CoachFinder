package com.practice.coach.finder.demo.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@ElementCollection
	private List<String> areas;
}
