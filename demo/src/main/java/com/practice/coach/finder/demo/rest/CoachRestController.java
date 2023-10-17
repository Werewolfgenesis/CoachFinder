package com.practice.coach.finder.demo.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.coach.finder.demo.dtos.CoachDTO;
import com.practice.coach.finder.demo.dtos.RequestDTO;
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
	
	@PostMapping
	public void register(@Valid @RequestBody CoachDTO dto) {
		service.registerCoach(dto.getFirstName(), dto.getLastName(), dto.getRate(), dto.getDescription(),dto.getAreas());
	}
	
	@PostMapping("/add-request")
	public void addRequest(@Valid @RequestBody RequestDTO dto) {
		service.addRequestToCoach(dto.getEmail(), dto.getMessage(), Long.valueOf(dto.getId()));
	}
	
	@GetMapping("/filter")
	public List<CoachDTO> filter(@RequestParam List<String> areas,
								 @RequestParam Integer pageNo,
								 @RequestParam Integer pageSize){
		return service.filterCoaches(areas, pageNo, pageSize);
	}
	
}
