package com.practice.coach.finder.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.coach.finder.demo.entities.CoachRequest;

@Repository
public interface RequestRepository extends JpaRepository<CoachRequest, String>{

}
