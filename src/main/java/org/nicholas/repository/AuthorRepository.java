package org.nicholas.repository;

import org.hibernate.SessionFactory;
import org.nicholas.model.Author;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorRepository extends RepositoryImpl<Author, Integer>{
    public AuthorRepository(SessionFactory factory){
        super(factory, Author.class);
    }
}
