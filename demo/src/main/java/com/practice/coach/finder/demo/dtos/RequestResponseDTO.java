package com.practice.coach.finder.demo.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestResponseDTO {
	@Email(message = "Value must have email format")
	@NotBlank(message = "Email cannot be empty")
	private String email;
	@NotBlank(message = "Message cannot be empty")
	private String message;
	@NotNull(message = "Coach cannot be null")
	private CoachDTO coach;
}
