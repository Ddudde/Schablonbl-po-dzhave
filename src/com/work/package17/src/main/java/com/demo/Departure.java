package com.demo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
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

    @ManyToOne
    private PostOffice post_office;

    @Column(name = "post_office_id", insertable = false, updatable = false)
    private int post_office_id;

    public void regPost_office_id() {
        try {
            post_office = DepartureTest.sessionFactory.getCurrentSession().createQuery(
                    "from postoffice where id = :id", PostOffice.class)
                    .setParameter("id", post_office_id).getSingleResult();
        } catch (Exception e)
        {
            post_office = DepartureTest.sessionFactory.openSession().createQuery(
                    "from postoffice where id = :id", PostOffice.class)
                    .setParameter("id", post_office_id).getSingleResult();
        }
    }

    @Override
    public String toString() {
        return "Departure{" +
                "type='" + type + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", post_office=" + post_office.toString() +
                '}';
    }
}
