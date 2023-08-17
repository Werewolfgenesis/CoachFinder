package com.practice.coach.finder.demo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.coach.finder.demo.dtos.AreaDTO;
import com.practice.coach.finder.demo.services.AreaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/private/api/areas")
@RequiredArgsConstructor
public class AreaRestController {
	private final AreaService service;
	
	@GetMapping
	public List<AreaDTO> getAreas(){
		return service.getAreas();
	}
}
