package org.nicholas.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Transactional

public class RepositoryImpl<T, K extends Number> implements DefaultRepository<T, K> {
    private SessionFactory sessionFactory;
    private Class<T> type;

    public RepositoryImpl(SessionFactory sessionFactory, Class<T> type){
        this.sessionFactory = sessionFactory;
        this.type = type;
    }

    @Override
    public List<T> findAll() {
        Session session = sessionFactory.getCurrentSession(); //here we do not use openSession, because it opens in Transactional (in proxy), so we have to obtain an opened one, but not open a new one
        Query query = session.createQuery("from " + type.getSimpleName());
        List<T> objects = query.getResultList();
        return objects;
    }

    @Override
    public T findById(K id) {
        Session session = sessionFactory.getCurrentSession();
        T obj = session.get(type, id);
        return obj;
    }

    @Override
    public void save(T obj) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(obj);
    }

    @Override
    public void delete(T obj) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(obj);
    }

    @Override
    public void deleteById(K id) {
        delete(findById(id));
    }
}
