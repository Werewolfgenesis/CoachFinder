package com.practice.coach.finder.demo.dtos;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoachDTO {
	@NotBlank(message = "Coach id must not be empty")
	private Long id;
	@NotBlank(message = "First name must not be empty")
	private String firstName;
	@NotBlank(message = "Last name must not be empty")
	private String lastName;
	@NotNull(message = "Rate should not be null")
	@PositiveOrZero(message = "Rate shoulbe be >= 0")
	private Double rate;
	@NotBlank(message = "Description must not be empty")
	private String description;
	private List<String> areas;
	private List<RequestDTO> requests;
}
