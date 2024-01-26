package org.nicholas.service;

import org.nicholas.model.OrderItem;
import org.nicholas.repository.DefaultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderItemService {
    DefaultRepository <OrderItem, Integer> repository;

    @Autowired
    public OrderItemService(@Qualifier("orderItemRepository") DefaultRepository<OrderItem, Integer> repository){
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
