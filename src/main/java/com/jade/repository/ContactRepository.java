package com.jade.repository;

import com.jade.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ContactRepository extends JpaRepository<Contact,String> {
    //Set<Contact> getAll();
}
