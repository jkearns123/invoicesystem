package com.jade.repository.impl;

import com.jade.domain.Customer;
import com.jade.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("InMemory1")
public class CustomerRepositoryImpl implements CustomerRepository {

    //singleton
    //make sure to use CustomerRepositoryImpl
    private static CustomerRepositoryImpl repository = null;
    private Set<Customer> customers;

    private CustomerRepositoryImpl(){
        this.customers = new HashSet<>();
    }

    //make sure to use CustomerRepositoryImpl
    public static CustomerRepositoryImpl getRepository(){
        if(repository == null) repository = new CustomerRepositoryImpl();
        return repository;
    }

    public Customer create(Customer customer){
        this.customers.add(customer);
        return customer;
    }

    public void delete(String customerId){
        Customer customer = findCustomer(customerId);
        if (customer != null)
        this.customers.remove(customer);
    }

    public Customer read(final String customerId){
        Customer customer = findCustomer(customerId);
        return customer;
    }

    private Customer findCustomer( final String customerId){
        for (Customer c : this.customers){
            if(c.getCustomerId().equals(customerId)) return c;
        }
        return null;
//        return this.customers.stream().filter(customer -> customer.getCustomerId().equals(customerId)).findAny().orElse(null);
    }

    public Customer update(Customer customer){
        Customer toDelete = findCustomer(customer.getCustomerId());
        if(toDelete != null){
            this.customers.remove(toDelete);
            return create(customer);
        }
        return null;
    }

    public Set<Customer> getAll(){
        return this.customers;
    }
}
