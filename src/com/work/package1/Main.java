package com.work.package1;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws IOException {
        Function<int[], Integer> abrakadabra = (x) -> {
            return gcd(x[0],x[1]);
        };
        Scanner in = new Scanner(System.in);
        int num1 = 0, num2 = 0;
        try {
            System.out.print("Ваше число: ");
            num1 = in.nextInt();
            System.out.print("Ваше число: ");
            num2 = in.nextInt();
        }
        catch (InputMismatchException e)
        {
            System.out.println("Введены некорректные данные!");
            return;
        }
        System.out.println("НОД: " + abrakadabra.apply(new int[]{num1, num2}));
    }
    private static int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }
}