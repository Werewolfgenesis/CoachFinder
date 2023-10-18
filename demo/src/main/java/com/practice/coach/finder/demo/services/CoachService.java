package com.practice.coach.finder.demo.services;

import java.util.List;

import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.coach.finder.demo.dtos.CoachDTO;
import com.practice.coach.finder.demo.dtos.RequestDTO;
import com.practice.coach.finder.demo.entities.Area;
import com.practice.coach.finder.demo.entities.Coach;
import com.practice.coach.finder.demo.entities.CoachRequest;
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
				.map(coach -> new CoachDTO(coach.getId(), coach.getFirstName(), coach.getLastName(), coach.getRate(),
						coach.getDescription(),
						coach.getAreas().stream().map(Area::getFullDesc).collect(Collectors.toList()),
						coach.getCoachRequest().stream()
								.map(request -> new RequestDTO(request.getEmail(), request.getMessage(), coach.getId().toString()))
								.collect(Collectors.toList())))
				.collect(Collectors.toList());
	}

	@Transactional(rollbackFor = Exception.class)
	public Coach registerCoach(String firstName, String lastName, Double rate, String description, List<String> areas) {
		List<Area> areasToSave = areas.stream().map(areaCode -> areaRepo.findById(areaCode).orElseThrow(EntityNotFoundException::new))
				.collect(Collectors.toList());
		Coach toSave = Coach.builder().firstName(firstName).lastName(lastName).rate(rate).description(description).areas(areasToSave).build();

		return coachRepo.save(toSave);
	}

	@Transactional(rollbackFor = Exception.class)
	public Coach addRequestToCoach(String email, String message, Long id) {
		Coach coachToSave = coachRepo.findById(id).orElseThrow(EntityNotFoundException::new);
		CoachRequest requestToSave = new CoachRequest(email, message, coachToSave);
		coachToSave.getCoachRequest().add(requestToSave);

		return coachRepo.save(coachToSave);
	}

	@Transactional(readOnly = true)
	public List<CoachDTO> filterCoaches(List<String> areas, Integer pageNo, Integer pageSize){
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		List<Coach> resultSet = coachRepo.getFilteredCoaches(areas, pageable);

		return resultSet.stream()
				.map(coach -> new CoachDTO(coach.getId(), coach.getFirstName(), coach.getLastName(), coach.getRate(),
						coach.getDescription(),
						coach.getAreas().stream().map(Area::getFullDesc).collect(Collectors.toList()),
						coach.getCoachRequest().stream()
								.map(request -> new RequestDTO(request.getEmail(), request.getMessage(), coach.getId().toString()))
								.collect(Collectors.toList())))
				.collect(Collectors.toList());
	}
}
