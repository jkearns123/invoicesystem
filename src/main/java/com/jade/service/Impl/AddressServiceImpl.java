package com.jade.service.Impl;

import com.jade.domain.Address;
import com.jade.repository.AddressRepository;
//import com.jade.repository.impl.AddressRepositoryImpl;
import com.jade.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AddressServiceImpl implements AddressService{

    private static AddressService service = null;

    @Autowired
    private AddressRepository repository;


    @Override
    public List<Address> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Address create(Address address) {
        return this.repository.save(address);
    }

    @Override
    public Address update(Address address) {
        return this.repository.save(address);
    }

    @Override
    public Address read(String s) {
        Optional<Address> opt = this.repository.findById(s);
        return opt.orElse(null);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }
}
