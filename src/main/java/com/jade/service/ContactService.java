package com.jade.service;

import com.jade.domain.Contact;

import java.util.List;
import java.util.Set;

public interface ContactService extends GenericService<Contact,String>{
    List<Contact> getAll();
}
