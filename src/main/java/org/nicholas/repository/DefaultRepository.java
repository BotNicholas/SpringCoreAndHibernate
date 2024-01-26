package org.nicholas.repository;

import java.util.List;

public interface DefaultRepository<T, K> {
    public List<T> findAll();
    public T findById(K id);
    public void save(T obj);
    public void delete(T obj);
    public void deleteById(K id);
}
