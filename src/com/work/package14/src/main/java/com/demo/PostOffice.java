package com.demo;

public class PostOffice {
    private final String name;
    private final String cityName;

    public PostOffice(String name, String cityName) {
        this.name = name;
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "PostOffice{" +
                "name='" + name + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
