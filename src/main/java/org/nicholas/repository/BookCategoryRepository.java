package org.nicholas.repository;

import org.hibernate.SessionFactory;
import org.nicholas.model.BookCategory;
import org.springframework.stereotype.Repository;

@Repository
public class BookCategoryRepository  extends RepositoryImpl<BookCategory, Integer>{
    public BookCategoryRepository(SessionFactory sessionFactory) {
        super(sessionFactory, BookCategory.class);
    }
}
