package org.nicholas.repository;

import org.hibernate.SessionFactory;
import org.nicholas.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository extends RepositoryImpl<Customer, Integer> {
    public CustomerRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Customer.class);
    }
}
