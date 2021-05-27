package com.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class Student {

    @Value("${student.name}")
    private String name;

    @Value("${student.last_name}")
    private String last_name;

    @Value("${student.group}")
    private String group;

    public Student() {
    }

    @PostConstruct
    public void init() {
        System.out.println("Student{" +
                "name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", group='" + group + '\'' +
                '}');
    }
}