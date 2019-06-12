package com.jade.service;

import com.jade.domain.Customer;

import java.util.Set;

public interface CustomerService extends GenericService<Customer,String>{

    Set<Customer> getAll();
}
