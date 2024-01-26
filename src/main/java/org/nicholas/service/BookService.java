package org.nicholas.service;

import org.nicholas.model.Author;
import org.nicholas.model.Book;
import org.nicholas.repository.DefaultRepository;

import java.util.List;

public class BookService {
    DefaultRepository <Book, Integer> repository;

    public BookService(DefaultRepository<Book, Integer> repository){
        this.repository = repository;
    }

    public List<Book> findAll() {
        return repository.findAll();
    }
    public Book findById(Integer id) {
        return repository.findById(id);
    }

    public void save(Book book) {
        repository.save(book);
    }
    public void delete(Book book) {
        repository.delete(book);
    }
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
