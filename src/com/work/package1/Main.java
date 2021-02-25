package com.work.package1;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws IOException {
        Function<int[], Integer> abrakadabra = (x) -> {
            int a = x[0];
            int b = x[1];
            if (a == 0)
                return b;

            while (b != 0) {
                if (a > b)
                    a = a - b;
                else
                    b = b - a;
            }
            return a;
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
}