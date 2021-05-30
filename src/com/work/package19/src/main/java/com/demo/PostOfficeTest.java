package com.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class PostOfficeTest {

    @Autowired
    public static PostRep postRep;

    public PostOfficeTest(PostRep postRep) {
        PostOfficeTest.postRep = postRep;
        log.info("init PostOfficeTest");
    }

    public void add(PostOffice postOffice) {
        log.info("add PostOffice");
        postRep.save(postOffice);
    }

    public List<PostOffice> getAll() {
        log.info("get PostOffices");
        return postRep.findAll();
    }

    public void delete(int id) {
        log.info("del PostOffice");
        postRep.delete(postRep.getOne(id));
    }

    public List<PostOffice> getByCrit(String crit, String arg)
    {
        log.info("get PostOffices by crit");
        if(crit.equals("name"))
            return postRep.findAllByName(arg);
        if(crit.equals("cityName"))
            return postRep.findAllByCityName(arg);
        return null;
    }
}