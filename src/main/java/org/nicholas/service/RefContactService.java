package org.nicholas.service;

import org.nicholas.model.Author;
import org.nicholas.model.RefContactType;
import org.nicholas.repository.DefaultRepository;

import java.util.List;

public class RefContactService {
    DefaultRepository <RefContactType, Integer> repository;

    public RefContactService(DefaultRepository<RefContactType, Integer> repository){
        this.repository = repository;
    }

    public List<RefContactType> findAll() {
        return repository.findAll();
    }
    public RefContactType findById(Integer id) {
        return repository.findById(id);
    }

    public void save(RefContactType aefContactType) {
        repository.save(aefContactType);
    }
    public void delete(RefContactType aefContactType) {
        repository.delete(aefContactType);
    }
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
