package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostOfficeController {

    @Autowired
    private PostOfficeTest test;

    @PostMapping("/postPostOffice")
    public void post(@RequestBody PostOffice postOffice) {
        test.add(postOffice);
    }

    @GetMapping("/getPostOffices")
    public List<String> getAll() {
        List<String> posts = new ArrayList<>();
        for(PostOffice sd : test.getAll()) posts.add(sd.toString());
        return posts;
    }

    @PostMapping("/deletePostOffice")
    public void delete(@RequestBody PostOffice postOffice) {
        test.delete(postOffice);
    }
}
