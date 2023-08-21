package com.practice.coach.finder.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.coach.finder.demo.dtos.CoachDTO;
import com.practice.coach.finder.demo.dtos.RequestResponseDTO;
import com.practice.coach.finder.demo.entities.Coach;
import com.practice.coach.finder.demo.repositories.RequestRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RequestService {
	
	private final RequestRepository requestRepository;
	
	@Transactional(readOnly = true)
	public List<RequestResponseDTO> getAllRequests(){
		return requestRepository.findAll()
				.stream()
				.map(request -> new RequestResponseDTO(request.getEmail(), request.getMessage(), this.convertToDto(request.getCoach())))
				.collect(Collectors.toList());
	}
	
	private CoachDTO convertToDto(Coach coach) {
		return CoachDTO.builder()
				.id(coach.getId())
				.firstName(coach.getFirstName())
				.lastName(coach.getLastName())
				.description(coach.getDescription())
				.build();
	}
}
