package com.jade.service.Impl;

import com.jade.domain.Contact;
import com.jade.repository.ContactRepository;
import com.jade.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ContactServiceImpl implements ContactService {

    private static ContactService service = null;

    @Autowired
    private ContactRepository repository;


    @Override
    public List<Contact> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Contact create(Contact contact) {
        return this.repository.save(contact);
    }

    @Override
    public Contact update(Contact contact) {
        return this.repository.save(contact);
    }

    @Override
    public Contact read(String s) {
        Optional<Contact> opt = this.repository.findById(s);
        return opt.orElse(null);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }
}
