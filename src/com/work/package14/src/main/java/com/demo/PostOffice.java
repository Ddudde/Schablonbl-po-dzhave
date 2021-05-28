package com.demo;

public class PostOffice {
    private String name;
    private String cityName;

    public PostOffice() {
    }

    public String getName() {
        return name;
    }

    public PostOffice(String name, String cityName) {
        this.name = name;
        this.cityName = cityName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
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
