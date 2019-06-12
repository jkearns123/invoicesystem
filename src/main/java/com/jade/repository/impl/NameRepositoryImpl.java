package com.jade.repository.impl;

import com.jade.domain.Name;
import com.jade.repository.NameRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("InMemory2")
public class NameRepositoryImpl implements NameRepository {

    private static NameRepositoryImpl repository = null;
    private Set<Name> names;

    private NameRepositoryImpl(){
        this.names = new HashSet<>();
    }

    private Name findName(final String nameId){
        for(Name n : this.names){
            if(n.getNameId().equals(nameId)) return n;
        }
        return null;
    }

    public static NameRepositoryImpl getRepository(){
        if(repository == null) repository = new NameRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Name> getAll() {
        return this.names;
    }

    @Override
    public Name create(Name name) {
        this.names.add(name);
        return name;
    }

    @Override
    public Name update(Name name) {
        Name toDelete = findName(name.getNameId());
        if(toDelete != null){
            this.names.remove(toDelete);
            return create(name);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        Name name = findName(s);
        if (name != null) this.names.remove(name);
    }

    @Override
    public Name read(final String s) {
        Name name = findName(s);
        return name;
    }
}
