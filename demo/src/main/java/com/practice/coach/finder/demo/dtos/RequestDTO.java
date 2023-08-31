package com.practice.coach.finder.demo.dtos;

import javax.validation.constraints.Email;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestDTO {
	@Email
	@NotBlank
	private String email;
	@NotBlank
	private String message;
	@NotBlank
	private String id;
}
