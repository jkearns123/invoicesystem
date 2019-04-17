package com.jade.repository;

import com.jade.domain.Customer;

import java.util.HashSet;
import java.util.Set;

//singleton
public interface CustomerRepository {

    Customer create(Customer customer);
    Customer update(Customer customer);
    Customer delete(Customer customer);
    Customer read(Customer customer);



}
