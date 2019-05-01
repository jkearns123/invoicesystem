package com.jade.repository.impl;

import com.jade.domain.Address;
import com.jade.repository.AddressRepository;

import java.util.HashSet;
import java.util.Set;

public class AddressRepositoryImpl implements AddressRepository {

    private static AddressRepositoryImpl repository = null;
    private Set<Address> addresses;

    private AddressRepositoryImpl(){
        this.addresses = new HashSet<>();
    }

    public static AddressRepository getRepository(){
        if(repository == null) repository = new AddressRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Address> getAll() {
        return this.getAll();
    }

    @Override
    public Address create(Address address) {
        this.addresses.add(address);
        return address;
    }

    @Override
    public Address update(Address address) {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public Address read(String s) {
        return null;
    }
}
