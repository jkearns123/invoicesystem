package com.jade.repository;

import com.jade.domain.Contact;

import java.util.Set;

public interface ContactRepository extends GenericRepository<Contact,String> {
    Set<Contact> getAll();
}
