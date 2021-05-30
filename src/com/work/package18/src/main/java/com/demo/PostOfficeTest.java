package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostOfficeTest {

    @Autowired
    public static PostRep postRep;

    public PostOfficeTest(PostRep postRep) {
        this.postRep = postRep;
    }

    public void add(PostOffice postOffice) {
        postRep.save(postOffice);
    }

    public List<PostOffice> getAll() {
        return postRep.findAll();
    }

    public void delete(int id) {
        postRep.delete(postRep.getOne(id));
    }

    public List<PostOffice> getByCrit(String crit, String arg)
    {
        if(crit.equals("name"))
            return postRep.findAllByName(arg);
        if(crit.equals("cityName"))
            return postRep.findAllByCityName(arg);
        return null;
    }
}