package com.jade.service.Impl;

import com.jade.domain.Sales;
import com.jade.repository.SalesRepository;
import com.jade.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SalesServiceImpl implements SalesService {

    private static SalesService service = null;

    @Autowired
    private SalesRepository repository;


    @Override
    public List<Sales> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Sales create(Sales sales) {
        return this.repository.save(sales);
    }

    @Override
    public Sales update(Sales sales) {
        return this.repository.save(sales);
    }

    @Override
    public Sales read(String s) {
        Optional<Sales> opt = this.repository.findById(s);
        return opt.orElse(null);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }
}
