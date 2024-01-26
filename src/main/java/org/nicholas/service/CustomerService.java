package org.nicholas.service;

import org.nicholas.model.Customer;
import org.nicholas.repository.DefaultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerService {
    DefaultRepository <Customer, Integer> repository;

    @Autowired
    public CustomerService(@Qualifier("customerRepository") DefaultRepository<Customer, Integer> repository){
        this.repository = repository;
    }

    public List<Customer> findAll() {
        return repository.findAll();
    }
    public Customer findById(Integer id) {
        return repository.findById(id);
    }

    public void save(Customer customer) {
        repository.save(customer);
    }
    public void delete(Customer customer) {
        repository.delete(customer);
    }
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
