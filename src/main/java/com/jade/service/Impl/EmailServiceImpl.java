package com.jade.service.Impl;

import com.jade.domain.Email;
import com.jade.repository.EmailRepository;
import com.jade.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailRepository repository;


    @Override
    public List<Email> getAll() {
        return repository.findAll();
    }

    @Override
    public Email create(Email email) {
        return this.repository.save(email);
    }

    @Override
    public Email update(Email email) {
        return this.repository.save(email);
    }

    @Override
    public Email read(String s) {
        Optional<Email> opt = this.repository.findById(s);
        return opt.orElse(null);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }
}
