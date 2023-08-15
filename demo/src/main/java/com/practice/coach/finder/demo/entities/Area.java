package com.practice.coach.finder.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Areas")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Area {
	@Id
	@Column(name = "CODE")
	private String code;
	
	@Column(name = "DESCRIPTION")
	private String fullDesc;
	
	@ManyToMany(mappedBy = "areas", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JsonIgnore  
	private List<Coach> coaches;
}
