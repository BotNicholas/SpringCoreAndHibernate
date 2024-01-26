package org.nicholas.service;

import org.nicholas.model.Author;
import org.nicholas.model.BookCategory;
import org.nicholas.repository.DefaultRepository;

import java.util.List;

public class BookCategoryService {
    DefaultRepository<BookCategory, Integer> repository;

    public BookCategoryService(DefaultRepository<BookCategory, Integer> repository){
        this.repository = repository;
    }

    public List<BookCategory> findAll() {
        return repository.findAll();
    }
    public BookCategory findById(Integer id) {
        return repository.findById(id);
    }

    public void save(BookCategory category) {
        repository.save(category);
    }
    public void delete(BookCategory category) {
        repository.delete(category);
    }
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
