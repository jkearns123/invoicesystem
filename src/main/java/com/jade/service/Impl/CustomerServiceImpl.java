package com.jade.service.Impl;

import com.jade.domain.Customer;
import com.jade.repository.CustomerRepository;
//import com.jade.repository.impl.CustomerRepositoryImpl;
import com.jade.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static CustomerService service = null;

    @Autowired
    private CustomerRepository repository;


    @Override
    public List<Customer> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Customer create(Customer customer) {
        return this.repository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return this.repository.save(customer);
    }

    @Override
    public Customer read(String s) {
        Optional<Customer> opt = this.repository.findById(s);
        return opt.orElse(null);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }
}
