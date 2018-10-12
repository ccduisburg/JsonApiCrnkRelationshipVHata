package com.codenotfound.crnk.domain.repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import com.codenotfound.crnk.domain.model.Person;

import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;

@Component
public class PersonRepositoryImpl extends ResourceRepositoryBase<Person, Long>
    implements PersonRepository {

    private SessionFactory sessionFactory;
    private void initSessionFactory() {
        sessionFactory= new Configuration().configure().buildSessionFactory();
    }
    private void closeSessionFactory() {
        if(sessionFactory != null && sessionFactory.isOpen()) {
            sessionFactory.close();
        }
    }
    protected PersonRepositoryImpl(Class<Person> resourceClass) {
        super(resourceClass);
        initSessionFactory();
    }

    public PersonRepositoryImpl() {
        this(Person.class);
    }

    @Override
    public ResourceList<Person> findAll(QuerySpec querySpec) {
        Session session = sessionFactory.openSession();
        List<Person> workers = null;
        workers = session.createQuery("from Person", Person.class).getResultList();
        session.close();
        return querySpec.apply(workers);
    }

    @Override
    public <S extends Person> S save(S s) {
        Session session = sessionFactory.openSession();
        S ret = null;
        try {
            session.getTransaction().begin();
            session.merge(s);
            session.getTransaction().commit();
            ret = s;
        } catch(Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return ret;
    }

    @Override
    public <S extends Person> S create(S s) {
        Session session = sessionFactory.openSession();
        S ret = null;
        try {
            session.getTransaction().begin();
            session.persist(s);
            session.getTransaction().commit();
            ret = s;
        } catch(Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return ret;
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            Person Person = session.find(Person.class, id);
            session.delete(Person);
            session.getTransaction().commit();
        } catch(Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}
