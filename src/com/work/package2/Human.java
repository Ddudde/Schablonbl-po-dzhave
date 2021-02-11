package com.work.package2;

import java.time.LocalDate;

public class Human {
    int age, weight;
    String firstName, lastName;
    LocalDate birthDate;

    public Human(int age, int weight, String firstName, String lastName, LocalDate birthDate) {
        this.age = age;
        this.weight = weight;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }
}
