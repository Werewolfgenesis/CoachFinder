package com.practice.coach.finder.demo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.coach.finder.demo.dtos.RequestResponseDTO;
import com.practice.coach.finder.demo.services.RequestService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("private/api/requests")
@RequiredArgsConstructor
public class RequestRestController {
	private final RequestService service;
	
	@GetMapping
	public List<RequestResponseDTO> getAll(){
		return service.getAllRequests();
	}
}
