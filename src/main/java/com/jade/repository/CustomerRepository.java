package com.jade.repository;

import com.jade.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashSet;
import java.util.Set;

public interface CustomerRepository extends JpaRepository<Customer,String> {
//    Set<Customer> getAll();
}
