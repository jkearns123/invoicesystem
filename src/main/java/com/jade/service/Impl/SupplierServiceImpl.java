package com.jade.service.Impl;

import com.jade.domain.Supplier;
import com.jade.repository.SupplierRepository;
import com.jade.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SupplierServiceImpl implements SupplierService {

    private static SupplierService service = null;

    @Autowired
    private SupplierRepository repository;


    @Override
    public List<Supplier> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Supplier create(Supplier supplier) {
        return this.repository.save(supplier);
    }

    @Override
    public Supplier update(Supplier supplier) {
        return this.repository.save(supplier);
    }

    @Override
    public Supplier read(String s) {
        Optional<Supplier> opt = this.repository.findById(s);
        return opt.orElse(null);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }
}
