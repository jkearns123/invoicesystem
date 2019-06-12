package com.jade.service.Impl;

import com.jade.domain.Customer;
import com.jade.repository.CustomerRepository;
import com.jade.repository.impl.CustomerRepositoryImpl;
import com.jade.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service("CustomerServiceImpl")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    @Qualifier("InMemory1")//remove singleton and replace with Autowired and Qualifier
    private CustomerRepository repository;


    @Override
    public Set<Customer> getAll() {
        return repository.getAll();
    }

    @Override
    public Customer create(Customer customer) {
        return repository.create(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return repository.update(customer);
    }

    @Override
    public Customer read(String s) {
        return repository.read(s);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }
}
