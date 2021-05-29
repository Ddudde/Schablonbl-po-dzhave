package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.util.List;
import java.util.logging.Logger;

@Service
public class DepartureTest{

    @Autowired
    public static SessionFactory sessionFactory;

    private Session session;

    public DepartureTest(SessionFactory sessionFactory) {
        DepartureTest.sessionFactory = sessionFactory;
        initialize();
    }

    private void initialize() {
        session = DepartureTest.sessionFactory.openSession();
    }

    @PreDestroy
    public void unSession() {
        session.close();
    }

    public void add(Departure departure) {
        session.beginTransaction();
        session.saveOrUpdate(departure);
        departure.regPost_office_id();
        session.getTransaction().commit();
    }

    public List<Departure> getAll() {
        return session.createQuery("From departure", Departure.class).list();
    }

    public void delete(int id) {
        session.beginTransaction();
        Departure departure = session.find(Departure.class, id);
        if(departure != null)
            session.delete(departure);
        session.getTransaction().commit();
    }

    public PostOffice getPostOffice(int id){
        return session.createQuery("from departure where id = :id", Departure.class)
                .setParameter("id",id).getSingleResult().getPost_office();
    }

}