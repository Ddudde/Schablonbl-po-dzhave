package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DepartureController {

    @Autowired
    private DepartureTest test;

    @PostMapping(value = "/postDeparture")
    public void post(@RequestBody Departure departure) {
        test.add(departure);
    }

    @GetMapping("/getDepartures")
    public List<String> getAll() {
        List<String> deps = new ArrayList<>();
        for(Departure sd : test.getAll()) deps.add(sd.toString());
        return deps;
    }

    @GetMapping("/deleteDeparture/{id}")
    public List<String> delete(@PathVariable int id) {
        test.delete(id);
        List<String> deps = new ArrayList<>();
        for(Departure sd : test.getAll()) deps.add(sd.toString());
        return deps;
    }

    @GetMapping("/getDepBy/{crit}/{arg}")
    public List<Departure> getFilteredByCrit(@PathVariable String crit, @PathVariable String arg){
        return test.getByCrit(crit, arg);
    }

    @GetMapping(value = "/departure/{Id}/post_office")
    public @ResponseBody PostOffice getPost(@PathVariable("Id") int id){
        return test.getPostOffice(id);
    }

}
