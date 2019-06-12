package com.jade.service.Impl;

import com.jade.domain.Sales;
import com.jade.repository.SalesRepository;
import com.jade.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("SalesServiceImpl")
public class SalesServiceImpl implements SalesService {

    @Autowired
    @Qualifier("InMemory9")
    private SalesRepository repository;


    @Override
    public Set<Sales> getAll() {
        return repository.getAll();
    }

    @Override
    public Sales create(Sales sales) {
        return repository.create(sales);
    }

    @Override
    public Sales update(Sales sales) {
        return repository.update(sales);
    }

    @Override
    public Sales read(String s) {
        return repository.read(s);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }
}
