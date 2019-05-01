package com.jade.repository.impl;

import com.jade.domain.Email;
import com.jade.repository.EmailRepository;

import java.util.HashSet;
import java.util.Set;

public class EmailRepositoryImpl implements EmailRepository {

    private static EmailRepositoryImpl repository = null;
    private Set<Email> emails;

    private EmailRepositoryImpl(){
        this.emails = new HashSet<>();
    }

    public static EmailRepository getRepository(){
        if(repository == null) repository = new EmailRepositoryImpl();
        return repository;
    }




    @Override
    public Email create(Email email) {
        this.emails.add(email);
        return email;
    }

    @Override
    public Email update(Email email) {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public Email read(String s) {
        return null;
    }


    public Set<Email> getAll() {
        return this.getAll();
    }
}
