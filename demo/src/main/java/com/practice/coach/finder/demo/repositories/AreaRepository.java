package com.practice.coach.finder.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.coach.finder.demo.entities.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, String>{

}
