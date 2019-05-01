package com.jade.repository.impl;

import com.jade.domain.Contact;
import com.jade.repository.ContactRepository;

import java.util.HashSet;
import java.util.Set;

public class ContactRepositoryImpl implements ContactRepository {

    private static ContactRepositoryImpl repository = null;
    private Set<Contact> contacts;

    private ContactRepositoryImpl(){
        this.contacts = new HashSet<>();
    }

    public static ContactRepository getRepository(){
        if(repository == null) repository = new ContactRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Contact> getAll() {
        return this.getAll();
    }

    @Override
    public Contact create(Contact contact) {
        this.contacts.add(contact);
        return contact;
    }

    @Override
    public Contact update(Contact contact) {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public Contact read(String s) {
        return null;
    }
}
