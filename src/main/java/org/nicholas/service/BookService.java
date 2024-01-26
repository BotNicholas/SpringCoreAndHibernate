package org.nicholas.service;

import org.nicholas.model.Author;
import org.nicholas.model.Book;
import org.nicholas.repository.DefaultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookService {
    DefaultRepository <Book, Integer> repository;

    @Autowired
    public BookService(@Qualifier("bookRepository") DefaultRepository<Book, Integer> repository){
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
