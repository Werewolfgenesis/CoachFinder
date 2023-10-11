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
	@Email(message = "Value must have an email format")
	@NotBlank(message = "Email cannot be empty")
	private String email;
	@NotBlank(message = "Message cannot be empty")
	private String message;
	@NotBlank(message = "Id cannot be empty")
	private String id;
}
