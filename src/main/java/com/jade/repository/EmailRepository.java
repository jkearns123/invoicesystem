package com.jade.repository;

import com.jade.domain.Email;

import java.util.Set;

public interface EmailRepository extends GenericRepository<Email,String> {
    Set<Email> getAll();
}
