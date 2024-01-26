package org.nicholas.repository;

import org.hibernate.SessionFactory;
import org.nicholas.model.Contact;
import org.springframework.stereotype.Repository;

@Repository
public class ContactRepository extends RepositoryImpl<Contact, Integer>{
    public ContactRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Contact.class);
    }
}
