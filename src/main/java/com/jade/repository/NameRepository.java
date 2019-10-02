package com.jade.repository;

import com.jade.domain.Name;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface NameRepository extends JpaRepository<Name,String> {
    //Set<Name> getAll();
}
