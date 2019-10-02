package com.jade.service;

import com.jade.domain.Email;

import java.util.List;
import java.util.Set;

public interface EmailService extends GenericService<Email,String>{
    List<Email> getAll();
}
