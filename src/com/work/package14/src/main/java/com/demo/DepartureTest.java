package com.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartureTest {

    private final List<Departure> departures;

    public DepartureTest() {
        departures = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        departures.add(new Departure("Письмо", "20.04.2021"));
        departures.add(new Departure("Бандероль", "10.05.2021"));
        departures.add(new Departure("Посылка", "20.05.2021"));
    }

    public void add(Departure departure) {
        departures.add(departure);
    }

    public List<Departure> getAll() {
        return departures;
    }

    public void delete(Departure departure) {
        departures.remove(departure);
    }
}