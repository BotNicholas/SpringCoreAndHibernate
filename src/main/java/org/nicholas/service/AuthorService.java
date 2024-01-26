package org.nicholas.service;

import org.nicholas.model.Author;
import org.nicholas.repository.DefaultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorService {
    DefaultRepository <Author, Integer> repository;

    @Autowired
    public AuthorService(@Qualifier(value = "authorRepository") DefaultRepository<Author, Integer> repository){
        this.repository = repository;
    }

    public List<Author> findAll() {
        return repository.findAll();
    }
    public Author findById(Integer id) {
        return repository.findById(id);
    }

    public void save(Author author) {
        repository.save(author);
    }
    public void delete(Author author) {
        repository.delete(author);
    }
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
