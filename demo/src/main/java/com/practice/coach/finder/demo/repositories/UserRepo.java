package com.practice.coach.finder.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.coach.finder.demo.security.CustomUser;

@Repository
public interface UserRepo extends JpaRepository<CustomUser, String>{

}
