package com.practice.coach.finder.demo.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.practice.coach.finder.demo.entities.Coach;

import java.util.List;

@Repository
public interface CoachRepository extends PagingAndSortingRepository<Coach, Long> {
    @Query(value = "select distinct c from Coach c join c.areas ca "
            + "where ca.code in (:areas)")
    List<Coach> getFilteredCoaches(List<String> areas, Pageable pageable);
    List<Coach> findAll();
}
