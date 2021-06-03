package com.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRep extends JpaRepository<PostOffice, Integer> {
    List<PostOffice> findAllByName(String name);
    List<PostOffice> findAllByCityName(String cityName);
}
