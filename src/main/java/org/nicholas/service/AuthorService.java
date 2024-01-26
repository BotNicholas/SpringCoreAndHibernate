package org.nicholas.service;

import org.nicholas.model.Author;
import org.nicholas.repository.DefaultRepository;

import java.util.List;

public class AuthorService {
    DefaultRepository <Author, Integer> repository;

    public AuthorService(DefaultRepository<Author, Integer> repository){
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
