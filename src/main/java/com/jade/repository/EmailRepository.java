package com.jade.repository;

import com.jade.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface EmailRepository extends JpaRepository<Email,String> {
    //Set<Email> getAll();
}
