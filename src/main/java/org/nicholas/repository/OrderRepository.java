package org.nicholas.repository;

import org.hibernate.SessionFactory;
import org.nicholas.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository extends RepositoryImpl<Order, Integer> {
    public OrderRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Order.class);
    }
}
