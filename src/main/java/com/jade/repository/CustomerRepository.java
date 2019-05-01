package com.jade.repository;

import com.jade.domain.Customer;

import java.util.HashSet;
import java.util.Set;

public interface CustomerRepository extends GenericRepository<Customer,String>{

    /*Customer create(Customer customer);
    Customer update(Customer customer);
    void delete(Customer customer);
    Customer read(String customerId);*/
    Set<Customer> getAll();

}
