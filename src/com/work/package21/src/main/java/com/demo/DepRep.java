package com.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepRep extends JpaRepository<Departure, Integer> {
    List<Departure> findAllByType(String type);
    List<Departure> findAllByDepartureDate(String departureDate);
}
