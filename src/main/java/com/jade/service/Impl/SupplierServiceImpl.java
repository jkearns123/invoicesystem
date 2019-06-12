package com.jade.service.Impl;

import com.jade.domain.Supplier;
import com.jade.repository.SupplierRepository;
import com.jade.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("SupplierServiceImpl")
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    @Qualifier("InMemory7")
    private SupplierRepository repository;


    @Override
    public Set<Supplier> getAll() {
        return repository.getAll();
    }

    @Override
    public Supplier create(Supplier supplier) {
        return repository.create(supplier);
    }

    @Override
    public Supplier update(Supplier supplier) {
        return repository.update(supplier);
    }

    @Override
    public Supplier read(String s) {
        return repository.read(s);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }
}
