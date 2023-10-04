package com.practice.coach.finder.demo.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AreaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "Area code cannot be empty")
	private String code;
	@NotBlank(message = "Area description cannot be empty")
	private String desc;
}
