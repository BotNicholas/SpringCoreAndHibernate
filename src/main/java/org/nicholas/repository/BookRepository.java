package org.nicholas.repository;


import org.hibernate.SessionFactory;
import org.nicholas.model.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository  extends RepositoryImpl<Book, Integer>{
    public BookRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Book.class);
    }
}
