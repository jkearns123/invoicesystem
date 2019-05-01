package com.jade.service;

import com.jade.domain.Customer;

public interface CustomerService {

    Customer create(Customer customer);
    Customer read(Customer customer);
    Customer update(Customer customer);
    Customer delete(Customer customer);
}
