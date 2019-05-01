package com.jade.repository;

import com.jade.domain.Name;

import java.util.Set;

public interface NameRepository extends GenericRepository<Name,String>{
    Set<Name> getAll();
}
