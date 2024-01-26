package org.nicholas.service;

import org.nicholas.model.Order;
import org.nicholas.repository.DefaultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderService {
    DefaultRepository <Order, Integer> repository;

    @Autowired
    public OrderService(@Qualifier("orderRepository") DefaultRepository<Order, Integer> repository){
        this.repository = repository;
    }

    public List<Order> findAll() {
        return repository.findAll();
    }
    public Order findById(Integer id) {
        return repository.findById(id);
    }

    public void save(Order order) {
        repository.save(order);
    }
    public void delete(Order order) {
        repository.delete(order);
    }
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
