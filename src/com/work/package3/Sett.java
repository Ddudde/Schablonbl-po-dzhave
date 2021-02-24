package com.work.package3;

import java.util.*;

public class Sett {

    public static void main(String[] argv)
    {
        try {
            Set<String> set = new HashSet<>();
            set.add("1");
            set.add("2");
            set.add("3");
            System.out.println("Set : " + set);
            Set<String> synset = Collections.synchronizedSet(set);
            System.out.println("Synchronized set is : " + synset);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Exception thrown : " + e);
        }
    }
}