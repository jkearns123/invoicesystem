package com.jade.repository.impl;

import com.jade.domain.Name;
import com.jade.repository.NameRepository;

import java.util.HashSet;
import java.util.Set;

public class NameRepositoryImpl implements NameRepository {

    private static NameRepositoryImpl repository = null;
    private Set<Name> names;

    private NameRepositoryImpl(){
        this.names = new HashSet<>();
    }

    public static NameRepository getRepository(){
        if(repository == null) repository = new NameRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Name> getAll() {
        return this.getAll();
    }

    @Override
    public Name create(Name name) {
        this.names.add(name);
        return name;
    }

    @Override
    public Name update(Name name) {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public Name read(String s) {
        return null;
    }
}
