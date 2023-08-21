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
	@Email
	@NotBlank
	private String email;
	@NotBlank
	private String message;
	@NotNull
	private CoachDTO coach;
}
