package com.practice.coach.finder.demo.services;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.coach.finder.demo.dtos.CoachDTO;
import com.practice.coach.finder.demo.entities.Area;
import com.practice.coach.finder.demo.entities.Coach;
import com.practice.coach.finder.demo.repositories.AreaRepository;
import com.practice.coach.finder.demo.repositories.CoachRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CoachService {

	private final CoachRepository coachRepo;
	private final AreaRepository areaRepo;

	@Transactional(readOnly = true)
	public List<CoachDTO> getAllCoaches() {
		return coachRepo.findAll().stream()
				.map(coach -> new CoachDTO(coach.getFirstName(), coach.getLastName(), coach.getRate(), coach.getAreas()
						.stream().map(area -> area.getFullDesc()).collect(Collectors.toList())))
				.collect(Collectors.toList());
	}

	@Transactional(rollbackFor = Exception.class)
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
}
