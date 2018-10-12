package com.codenotfound.crnk.domain.repository;


import com.codenotfound.crnk.domain.model.Persondepartment;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersondepartmentRepositoryImpl extends ResourceRepositoryBase<Persondepartment, Integer> implements PersondepartmentRepository {

    private SessionFactory sessionFactory;
    private void initSessionFactory() {
        sessionFactory= new Configuration().configure().buildSessionFactory();
    }
    private void closeSessionFactory() {
        if(sessionFactory != null && sessionFactory.isOpen()) {
            sessionFactory.close();
        }
    }
    protected PersondepartmentRepositoryImpl(Class<Persondepartment> resourceClass) {
        super(resourceClass);
        initSessionFactory();
    }

    public PersondepartmentRepositoryImpl() {
        this(Persondepartment.class);
    }

    @Override
    public ResourceList<Persondepartment> findAll(QuerySpec querySpec) {
        Session session = sessionFactory.openSession();
        List<Persondepartment> workers = null;
        workers = session.createQuery("from Persondepartment", Persondepartment.class).getResultList();
        session.close();
        return querySpec.apply(workers);
    }

    @Override
    public <S extends Persondepartment> S save(S s) {
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
    public <S extends Persondepartment> S create(S s) {
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
    public void delete(Integer id) {
        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            Persondepartment Persondepartment = session.find(Persondepartment.class, id);
            session.delete(Persondepartment);
            session.getTransaction().commit();
        } catch(Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}
