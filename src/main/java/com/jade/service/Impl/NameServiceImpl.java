package com.jade.service.Impl;

import com.jade.domain.Name;
import com.jade.repository.NameRepository;
import com.jade.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("NameServiceImpl")
public class NameServiceImpl implements NameService {

    @Autowired
    @Qualifier("InMemory2")
    private NameRepository repository;


    @Override
    public Set<Name> getAll() {
        return repository.getAll();
    }

    @Override
    public Name create(Name name) {
        return repository.create(name);
    }

    @Override
    public Name update(Name name) {
        return repository.update(name);
    }

    @Override
    public Name read(String s) {
        return repository.read(s);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }
}
