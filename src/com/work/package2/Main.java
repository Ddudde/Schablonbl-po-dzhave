package com.work.package2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    private List<Human> humans;
    public BigInteger ow = BigInteger.ONE;

    public Main(List<Human> humans) {
        this.humans = humans;
        System.out.println("Сортировка по второй букве имени - 1\n" +
                "Фильтрация по весу кратно 10 - 2\n" +
                "Сортировка по произведению веса на возраст - 3\n" +
                "Произведение всех весов - 4\n");
        Scanner in = new Scanner(System.in);
        int num = 0;
        try {
            System.out.print("Ваш выбор: ");
            num = in.nextInt();
        }
        catch (InputMismatchException e)
        {
            System.out.println("Введены некорректные данные!");
            return;
        }
        switch (num)
        {
            case 1:
                VBI();
                break;
            case 2:
                KRD();
                break;
            case 3:
                PRVNV();
                break;
            case 4:
                PRVV();
                break;
            default:
                System.out.println("Не повезло не повезло");
        }
    }

    public void VBI()
    {
        Stream<Human> stream = humans.stream();
        stream.sorted((i1, i2) -> {
            int vbi1 = (int)(i1.firstName.charAt(1));
            int vbi2 = (int)(i2.firstName.charAt(1));
            if(vbi1 > vbi2)
                return 1;
            if(vbi1 < vbi2)
                return -1;
            return 0;
        }).forEach(Main::vyvod);
    }
    public void KRD()
    {
        Stream<Human> stream = humans.stream();
        stream.filter(str -> str.weight % 10 == 0).forEach(Main::vyvod);
    }
    public void PRVNV()
    {
        Stream<Human> stream = humans.stream();
        stream.sorted((i1, i2) -> {
            int vbi1 = i1.age * i1.weight;
            int vbi2 = i2.age * i2.weight;
            if(vbi1 > vbi2)
                return 1;
            if(vbi1 < vbi2)
                return -1;
            return 0;
        }).forEach(Main::vyvod);
    }
    public void PRVV()
    {
        Stream<Human> stream = humans.stream();
        stream.forEach(str -> {
            ow = ow.multiply(new BigInteger(str.weight + ""));
        });
        System.out.println("Произведение всех весов: " + ow);
        ow = BigInteger.ONE;
    }
    public static void vyvod(Human h)
    {
        System.out.println("");
        System.out.println("Следующий человек: ");
        System.out.println(h.age);
        System.out.println(h.firstName);
        System.out.println(h.lastName);
        System.out.println(h.weight);
        System.out.println(h.birthDate);
    }
}
