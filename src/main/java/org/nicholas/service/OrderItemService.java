package org.nicholas.service;

import org.nicholas.model.OrderItem;
import org.nicholas.repository.DefaultRepository;

import java.util.List;

public class OrderItemService {
    DefaultRepository <OrderItem, Integer> repository;

    public OrderItemService(DefaultRepository<OrderItem, Integer> repository){
        this.repository = repository;
    }

    public List<OrderItem> findAll() {
        return repository.findAll();
    }
    public OrderItem findById(Integer id) {
        return repository.findById(id);
    }

    public void save(OrderItem orderItem) {
        repository.save(orderItem);
    }
    public void delete(OrderItem orderItem) {
        repository.delete(orderItem);
    }
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
