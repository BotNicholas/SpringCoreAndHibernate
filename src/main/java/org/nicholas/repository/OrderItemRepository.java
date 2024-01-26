package org.nicholas.repository;

import org.hibernate.SessionFactory;
import org.nicholas.model.OrderItem;
import org.springframework.stereotype.Repository;

@Repository
public class OrderItemRepository extends RepositoryImpl<OrderItem, Integer> {
    public OrderItemRepository(SessionFactory sessionFactory) {
        super(sessionFactory, OrderItem.class);
    }
}
