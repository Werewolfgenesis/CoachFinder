package com.practice.coach.finder.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.practice.coach.finder.demo.dtos.CoachDTO;
import com.practice.coach.finder.demo.repositories.CoachRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CoachService {
 
	private final CoachRepository coachRepo;
	
	
	public List<CoachDTO> getAllCoaches(){
		return coachRepo.findAll()
				.stream()
				.map(coach ->  new CoachDTO(coach.getFirstName(), coach.getLastName(), coach.getRate(), coach.getAreas()))
				.collect(Collectors.toList());
	}
}
