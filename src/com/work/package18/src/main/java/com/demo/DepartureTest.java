package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class DepartureTest{

    @Autowired
    public static DepRep depRep;

    public DepartureTest(DepRep depRep) {
        DepartureTest.depRep = depRep;
    }

    public void add(Departure departure) {
        depRep.save(departure);
        departure.regPost_office_id();
        depRep.save(departure);
    }

    public List<Departure> getAll() {
        return depRep.findAll();
    }

    public void delete(int id) {
        depRep.delete(depRep.getOne(id));
    }

    public PostOffice getPostOffice(int id){
        return depRep.getOne(id).getPost_office();
    }

    public List<Departure> getByCrit(String crit, String arg)
    {
        if(crit.equals("type"))
            return depRep.findAllByType(arg);
        if(crit.equals("departureDate"))
            return depRep.findAllByDepartureDate(arg);
        return null;
    }
}