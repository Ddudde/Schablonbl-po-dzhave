package com.demo;

public class Departure {
    private String type;
    private String departureDate;

    public Departure() {
    }

    public Departure(String type, String departureDate) {
        this.type = type;
        this.departureDate = departureDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
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
