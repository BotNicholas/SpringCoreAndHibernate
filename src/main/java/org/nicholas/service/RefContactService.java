package org.nicholas.service;

import org.nicholas.model.Author;
import org.nicholas.model.RefContactType;
import org.nicholas.repository.DefaultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RefContactService {
    DefaultRepository <RefContactType, Integer> repository;

    @Autowired
    public RefContactService(@Qualifier("refContactTypeRepository") DefaultRepository<RefContactType, Integer> repository){
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
