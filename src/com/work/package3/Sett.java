package com.work.package3;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class Sett {

    public static void main(String[] argv)
    {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(2);
            Set<String> set = new HashSet<>();
            set.add("1");
            set.add("2");
            set.add("3");
            System.out.println("Set : " + set);
            Set<String> synset = Collections.synchronizedSet(set);
            System.out.println("Synchronized set is : " + synset);
            executor.submit(() -> {
                synset.add("4");
                System.out.println(synset);
            });
            executor.submit(() -> {
                synset.add("5");
                System.out.println(synset);
            });
        }
        catch (IllegalArgumentException e) {
            System.out.println("Exception thrown : " + e);
        }
    }
}