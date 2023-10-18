package com.practice.coach.finder.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.coach.finder.demo.dtos.AreaDTO;
import com.practice.coach.finder.demo.repositories.AreaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AreaService {
	private final AreaRepository repo;
	
//	@Cacheable(
//		      value = "areasCache")
	@Transactional(readOnly = true)
	public List<AreaDTO> getAreas(){
		return repo.findAll().stream()
				.map(area -> new AreaDTO(area.getCode(), area.getFullDesc()))
				.collect(Collectors.toList());
	}
	
}
