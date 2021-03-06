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
public class PostOfficeTest {

    @Autowired
    private final SessionFactory sessionFactory;

    private Session session;

    private CriteriaBuilder builder;

    private CriteriaQuery<PostOffice> postCriteriaQuery;

    private Root<PostOffice> root;

    public PostOfficeTest(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        initialize();
    }

    private void initialize() {
        session = sessionFactory.openSession();
        builder = session.getCriteriaBuilder();
        postCriteriaQuery = builder.createQuery(PostOffice.class);
        root = postCriteriaQuery.from(PostOffice.class);
    }

    @PreDestroy
    public void unSession() {
        session.close();
    }

    public void add(PostOffice postOffice) {
        session.beginTransaction();
        session.saveOrUpdate(postOffice);
        session.getTransaction().commit();
    }

    public List<PostOffice> getAll() {
        return session.createQuery("From postoffice", PostOffice.class).list();
    }

    public void delete(int id) {
        session.beginTransaction();
        PostOffice postOffice = session.find(PostOffice.class, id);
        if(postOffice != null)
            session.delete(postOffice);
        session.getTransaction().commit();
    }

    public List<PostOffice> getByCrit(String crit) {
        postCriteriaQuery.select(root).orderBy(builder.asc(root.get(crit)));
        Query<PostOffice> query = session.createQuery(postCriteriaQuery);
        return query.getResultList();
    }
}