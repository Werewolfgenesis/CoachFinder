package com.practice.coach.finder.demo.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoachDTO {

	private String firstName;
	private String lastName;
	private Double rate;
	private List<String> areas;
}
