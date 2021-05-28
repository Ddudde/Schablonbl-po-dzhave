package com.demo;

import javax.persistence.*;

@Entity(name = "departure")
@Table(name = "departure")
public class Departure {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "departure_date")
    private String departureDate;

    public Departure() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", type='" + type + '\'' +
                ", departureDate='" + departureDate + '\'' +
                '}';
    }
}
