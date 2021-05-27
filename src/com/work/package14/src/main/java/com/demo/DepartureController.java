package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class DepartureController {

    @Autowired
    private DepartureTest test;

    @PostMapping("/postDeparture")
    public void post(@RequestBody Departure departure) {
        test.add(departure);
    }

    @GetMapping("/getDepartures")
    public List<String> getAll() {
        List<String> deps = new ArrayList<>();
        for(Departure sd : test.getAll()) deps.add(sd.toString());
        return deps;
    }

    @DeleteMapping("/deleteDeparture")
    public void delete(@RequestBody Departure departure) {
        test.delete(departure);
    }

}
