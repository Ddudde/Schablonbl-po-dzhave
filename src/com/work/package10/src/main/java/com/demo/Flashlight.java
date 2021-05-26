package com.demo;

public class Flashlight implements Lighter{
    @Override
    public void doLight() {
        System.out.println("Flashlight doLight!");
    }
}
