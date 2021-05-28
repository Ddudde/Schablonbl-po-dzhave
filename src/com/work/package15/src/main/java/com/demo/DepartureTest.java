package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.util.List;

@Service
public class DepartureTest{

    @Autowired
    private final SessionFactory sessionFactory;

    private Session session;

    public DepartureTest(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        initialize();
    }

    private void initialize() {
        session = sessionFactory.openSession();
    }

    @PreDestroy
    public void unSession() {
        session.close();
    }

    public void add(Departure departure) {
        session.beginTransaction();
        session.saveOrUpdate(departure);
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
}