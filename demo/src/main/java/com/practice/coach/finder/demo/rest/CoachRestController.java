package com.practice.coach.finder.demo.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public void register(@RequestBody CoachDTO dto) {
		service.registerCoach(dto.getFirstName(), dto.getLastName(), dto.getRate(), dto.getAreas());
	}
	
	@PostMapping("/{id}/add-request")
	public void addRequest(@PathVariable("id") String id , @RequestBody RequestDTO dto) {
//		System.err.println(id);
		service.addRequestToCoach(dto.getEmail(), dto.getMessage(), Long.valueOf(id));
	}
	
}
