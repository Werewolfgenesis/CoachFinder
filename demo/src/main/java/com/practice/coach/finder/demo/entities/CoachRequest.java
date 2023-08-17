package com.practice.coach.finder.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Requests")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CoachRequest {

	@Id
	@Column(name = "EMAIL", nullable = false)
	private String email;
	

	@Column(name = "MESSAGE", nullable = false)
	private String message;
	
	@ManyToOne
	@JoinColumn(name = "COACH_ID", nullable = false)
	private Coach coach;
	
	
}
