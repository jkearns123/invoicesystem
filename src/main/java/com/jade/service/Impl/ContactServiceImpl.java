package com.jade.service.Impl;

import com.jade.domain.Contact;
import com.jade.repository.ContactRepository;
import com.jade.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("ContactServiceImpl")
public class ContactServiceImpl implements ContactService {

    @Autowired
    @Qualifier("InMemory5")
    private ContactRepository repository;


    @Override
    public Set<Contact> getAll() {
        return repository.getAll();
    }

    @Override
    public Contact create(Contact contact) {
        return repository.create(contact);
    }

    @Override
    public Contact update(Contact contact) {
        return repository.update(contact);
    }

    @Override
    public Contact read(String s) {
        return repository.read(s);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }
}
