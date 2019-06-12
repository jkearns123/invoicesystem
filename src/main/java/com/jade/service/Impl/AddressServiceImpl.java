package com.jade.service.Impl;

import com.jade.domain.Address;
import com.jade.repository.AddressRepository;
import com.jade.repository.impl.AddressRepositoryImpl;
import com.jade.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("AddressServiceImpl")
public class AddressServiceImpl implements AddressService{

    @Autowired
    @Qualifier("InMemory4")
    private AddressRepository repository;


    @Override
    public Set<Address> getAll() {
        return repository.getAll();
    }

    @Override
    public Address create(Address address) {
        return repository.create(address);
    }

    @Override
    public Address update(Address address) {
        return repository.update(address);
    }

    @Override
    public Address read(String s) {
        return repository.read(s);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }
}
