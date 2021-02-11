package com.work.package1;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<int[], Integer> abrakadabra = (x) -> {
            return gcd(x[0],x[1]);
        };
        System.out.println(abrakadabra.apply(new int[]{6, 3}));
    }
    private static int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }
}