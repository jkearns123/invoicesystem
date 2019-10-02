package com.jade.service.Impl;

import com.jade.domain.Name;
import com.jade.repository.NameRepository;
import com.jade.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class NameServiceImpl implements NameService {

    private static NameService service = null;

    @Autowired
    private NameRepository repository;


    @Override
    public List<Name> getAll() {
        return repository.findAll();
    }

    @Override
    public Name create(Name name) {
        return this.repository.save(name);
    }

    @Override
    public Name update(Name name) {
        return this.repository.save(name);
    }

    @Override
    public Name read(String s) {
        Optional<Name> opt = this.repository.findById(s);
        return opt.orElse(null);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }
}
