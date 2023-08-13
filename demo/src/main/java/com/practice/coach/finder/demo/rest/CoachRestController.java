package com.practice.coach.finder.demo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.coach.finder.demo.dtos.CoachDTO;
import com.practice.coach.finder.demo.services.CoachService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/private/api/coaches")
@RequiredArgsConstructor
public class CoachRestController {

	private final CoachService service;
	
	@GetMapping("/all")
	public List<CoachDTO> getAllCoaches(){
		return service.getAllCoaches();
	}
	
}
