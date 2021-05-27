package com.demo;

public class Departure {
    private final String type;
    private final String departureDate;

    public Departure(String type, String departureDate) {
        this.type = type;
        this.departureDate = departureDate;
    }

    @Override
    public String toString() {
        return "Departure{" +
                "type='" + type + '\'' +
                ", departureDate='" + departureDate + '\'' +
                '}';
    }
}
