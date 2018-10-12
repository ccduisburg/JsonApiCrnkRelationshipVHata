package com.codenotfound.crnk.domain.repository;


import com.codenotfound.crnk.domain.model.Worker;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WorkerRepositoryImpl extends ResourceRepositoryBase<Worker, Long> implements WorkerRepository {

    private SessionFactory sessionFactory;
    private void initSessionFactory() {
        sessionFactory= new Configuration().configure().buildSessionFactory();
    }
    private void closeSessionFactory() {
        if(sessionFactory != null && sessionFactory.isOpen()) {
            sessionFactory.close();
        }
    }
    protected WorkerRepositoryImpl(Class<Worker> resourceClass) {
        super(resourceClass);
        initSessionFactory();
    }

    public WorkerRepositoryImpl() {
        this(Worker.class);
    }

    @Override
    public ResourceList<Worker> findAll(QuerySpec querySpec) {
        Session session = sessionFactory.openSession();
        List<Worker> workers = null;
        workers = session.createQuery("from Worker", Worker.class).getResultList();
        session.close();
        return querySpec.apply(workers);
    }

    @Override
    public <S extends Worker> S save(S s) {
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
    public <S extends Worker> S create(S s) {
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
            Worker worker = session.find(Worker.class, id);
            session.delete(worker);
            session.getTransaction().commit();
        } catch(Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}
