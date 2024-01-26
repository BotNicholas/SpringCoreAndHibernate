package org.nicholas.service;

import org.nicholas.model.Contact;
import org.nicholas.repository.DefaultRepository;

import java.util.List;

public class ContactService {
    DefaultRepository <Contact, Integer> repository;

    public ContactService(DefaultRepository<Contact, Integer> repository){
        this.repository = repository;
    }

    public List<Contact> findAll() {
        return repository.findAll();
    }
    public Contact findById(Integer id) {
        return repository.findById(id);
    }

    public void save(Contact contact) {
        repository.save(contact);
    }
    public void delete(Contact contact) {
        repository.delete(contact);
    }
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
