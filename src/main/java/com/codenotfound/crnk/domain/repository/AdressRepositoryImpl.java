package com.codenotfound.crnk.domain.repository;

import com.codenotfound.crnk.domain.model.Adress;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class AdressRepositoryImpl extends ResourceRepositoryBase<Adress, Long> implements AdressRepository {

    private SessionFactory sessionFactory;
    private void initSessionFactory() {
        sessionFactory= new Configuration().configure().buildSessionFactory();
    }
    private void closeSessionFactory() {
        if(sessionFactory != null && sessionFactory.isOpen()) {
            sessionFactory.close();
        }
    }
    protected AdressRepositoryImpl(Class<Adress> resourceClass) {
        super(resourceClass);
        initSessionFactory();
    }

    public AdressRepositoryImpl() {
        this(Adress.class);
    }

    @Override
    public ResourceList<Adress> findAll(QuerySpec querySpec) {
        Session session = sessionFactory.openSession();
        List<Adress> adress = null;
        adress = session.createQuery("from Adress", Adress.class).getResultList();
        session.close();
        return querySpec.apply(adress);
    }

    @Override
    public <S extends Adress> S save(S s) {
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
    public <S extends Adress> S create(S s) {
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
            Adress adress = session.find(Adress.class, id);
            session.delete(adress);
            session.getTransaction().commit();
        } catch(Exception ex) {
            ex.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }
}
