package com.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class DepartureTest{

    @Autowired
    public static DepRep depRep;

    public DepartureTest(DepRep depRep) {
        log.info("init DepartureTest");
        DepartureTest.depRep = depRep;
    }

    public void add(Departure departure) {
        log.info("add Departure...");
        depRep.save(departure);
        departure.regPost_office_id();
        depRep.save(departure);
    }

    public List<Departure> getAll() {
        log.info("get Departures...");
        return depRep.findAll();
    }

    public void delete(int id) {
        log.info("delete Departure...");
        depRep.delete(depRep.getOne(id));
    }

    public PostOffice getPostOffice(int id){
        log.info("get post_office of departure...");
        return depRep.getOne(id).getPost_office();
    }

    public List<Departure> getByCrit(String crit, String arg)
    {
        log.info("get Departures by Crit...");
        if(crit.equals("type"))
            return depRep.findAllByType(arg);
        if(crit.equals("departureDate"))
            return depRep.findAllByDepartureDate(arg);
        return null;
    }
}