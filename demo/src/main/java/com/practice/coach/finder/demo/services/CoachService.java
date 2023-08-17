package com.practice.coach.finder.demo.services;

import java.util.List;

import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.coach.finder.demo.dtos.CoachDTO;
import com.practice.coach.finder.demo.entities.Area;
import com.practice.coach.finder.demo.entities.Coach;
import com.practice.coach.finder.demo.entities.CoachRequest;
import com.practice.coach.finder.demo.repositories.AreaRepository;
import com.practice.coach.finder.demo.repositories.CoachRepository;
import com.practice.coach.finder.demo.repositories.RequestRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
//@RequiredArgsConstructor
@AllArgsConstructor
public class CoachService {

	private final CoachRepository coachRepo;
	private final AreaRepository areaRepo;
	private final RequestRepository requestRepo;

	public List<CoachDTO> getAllCoaches() {
		return coachRepo.findAll().stream()
				.map(coach -> new CoachDTO(coach.getFirstName(), coach.getLastName(), coach.getRate(), coach.getAreas()
						.stream().map(area -> area.getFullDesc()).collect(Collectors.toList())))
				.collect(Collectors.toList());
	}

	public Coach registerCoach(String firstName, String lastName, Double rate, List<String> areas) {
		List<Area> areasToSave = areas.stream()
				.map(areaCode -> areaRepo.findById(areaCode).orElseThrow())
				.collect(Collectors.toList());
		Coach toSave = Coach.builder()
				.firstName(firstName)
				.lastName(lastName)
				.rate(rate)
				.areas(areasToSave)
				.build();
		
		return coachRepo.save(toSave);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public Coach addRequestToCoach(String email, String message, Long id) {
		Coach coachToSave = coachRepo.findById(id).orElseThrow(EntityNotFoundException::new);
		CoachRequest requestToSave = new CoachRequest(email, message, coachToSave);
		requestRepo.save(requestToSave);
		coachToSave.getCoachRequest().add(requestToSave);
		
		return coachRepo.save(coachToSave);
	}
}
