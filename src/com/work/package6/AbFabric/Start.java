package com.work.package6.AbFabric;

public class Start {
    public static void main(String[] args) {
        CarsFactory factory;
        factory = new ToyotaFactory();
        factory.createSedan();
    }
}
