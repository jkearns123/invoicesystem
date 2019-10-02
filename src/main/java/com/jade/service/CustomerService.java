package com.jade.service;

import com.jade.domain.Customer;

import java.util.List;
import java.util.Set;

public interface CustomerService extends GenericService<Customer,String>{

    List<Customer> getAll();
}
