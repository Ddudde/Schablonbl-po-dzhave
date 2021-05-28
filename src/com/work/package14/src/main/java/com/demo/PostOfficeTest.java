package com.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostOfficeTest {

    private List<PostOffice> postOffices;

    public PostOfficeTest() {
        postOffices = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        postOffices.add(new PostOffice("Это скандал!", "Москва"));
        postOffices.add(new PostOffice("Давно не виделись", "Санкт-Петербург"));
        postOffices.add(new PostOffice("к19_16", "Москва"));
    }

    public void add(PostOffice postOffice) {
        postOffices.add(postOffice);
    }

    public List<PostOffice> getAll() {
        return postOffices;
    }

    public void delete(PostOffice postOffice) {
        postOffices.remove(postOffice);
    }
}