package com.work.package6.Fabric;

import java.util.ArrayList;
import java.util.List;

abstract class Car{
    String name;
    List <String> accessories = new ArrayList();

    public String toString(){
        return "Model car: " + name + "\n" + accessories;
    }
}

abstract class CarFactory{
    public abstract Car createCar();

}

class LuxCarFactory extends CarFactory{
    public Car createCar(){
        return new LuxCar();
    }

}

class BasicCarFactory extends CarFactory{
    public Car createCar(){
        return new BasicCar();
    }

}

class LuxCar extends Car{
    public LuxCar(){
        name = "Luxury Car";
        accessories.add("Leather salon");
        accessories.add("Air condition");
        accessories.add("GPS");
        accessories.add("Heated steering wheel");
    }
}

class BasicCar extends Car{
    public BasicCar(){
        name = "Basic Car";
        accessories.add("Basic salon");
        accessories.add("Air condition");
    }
}

public class Example{
    public static void main(String[] args) {
        CarFactory myLuxFactory = new LuxCarFactory();
        CarFactory myBasicFactory = new BasicCarFactory();

        Car myLuxCar = myLuxFactory.createCar();
        Car myBasicCar = myBasicFactory.createCar();

        System.out.println(myLuxCar);
        System.out.println(myBasicCar);
    }
}