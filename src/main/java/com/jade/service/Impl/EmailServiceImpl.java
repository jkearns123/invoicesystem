package com.jade.service.Impl;

import com.jade.domain.Email;
import com.jade.repository.EmailRepository;
import com.jade.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("EmailServiceImpl")
public class EmailServiceImpl implements EmailService {

    @Autowired
    @Qualifier("InMemory3")
    private EmailRepository repository;


    @Override
    public Set<Email> getAll() {
        return repository.getAll();
    }

    @Override
    public Email create(Email email) {
        return repository.create(email);
    }

    @Override
    public Email update(Email email) {
        return repository.update(email);
    }

    @Override
    public Email read(String s) {
        return repository.read(s);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }
}
