package com.work.package2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Generator {
    private static List<Human> humans = new ArrayList<>();
    private static String[] imena = {"Alex", "Anthony", "Brandon", "Christopher", "David"};
    private static String[] limena = {"Allen", "Anderson", "Brown", "Clark", "Davis"};
    public static void main(String[] args) {
        for(int i = 0; i < 50; i++){
            int currY = LocalDateTime.now().getYear();
            int YearOB = (int)(Math.random()*(currY-20));
            humans.add(new Human((currY - YearOB), (int) (Math.random() * 150) + 50, imena[(int)(Math.random()*4)], limena[(int)(Math.random()*4)], LocalDate.of(YearOB, (int)(Math.random()*11) + 1, (int)(Math.random()*27)+1)));
        }
        new Main(humans);
    }
}
