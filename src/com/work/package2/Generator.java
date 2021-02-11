package com.work.package2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Generator {
    private static List<Human> humans = new ArrayList<>();
    private static String[] imena = {"Alex", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
    public static void main(String[] args) {
        for(int i = 0; i < 50; i++){
            humans.add(new Human((int)(Math.random() * 100), (int) (Math.random() * 150) + 50, "", "", LocalDate.of(1914, 12, 31)));
        }
        for(Human hum : humans){
            System.out.println(hum.age);
            System.out.println(hum.firstName);
            System.out.println(hum.lastName);
            System.out.println(hum.weight);
            System.out.println(hum.birthDate);
            System.out.println("");
            System.out.println("Следующий человек: ");
        }
    }
}
