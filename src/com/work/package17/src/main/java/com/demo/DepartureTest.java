package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class DepartureTest{

    @Autowired
    public static SessionFactory sessionFactory;

    private Session session;

    private CriteriaBuilder builder;

    private CriteriaQuery<Departure> depCriteriaQuery;

    private Root<Departure> root;

    public DepartureTest(SessionFactory sessionFactory) {
        DepartureTest.sessionFactory = sessionFactory;
        initialize();
    }

    private void initialize() {
        session = DepartureTest.sessionFactory.openSession();
        builder = session.getCriteriaBuilder();
        depCriteriaQuery = builder.createQuery(Departure.class);
        root = depCriteriaQuery.from(Departure.class);
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

    public List<Departure> getByCrit(String crit) {
        depCriteriaQuery.select(root).orderBy(builder.asc(root.get(crit)));
        Query<Departure> query = session.createQuery(depCriteriaQuery);
        return query.getResultList();
    }
}