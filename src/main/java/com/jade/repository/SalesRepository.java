package com.jade.repository;

import com.jade.domain.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface SalesRepository extends JpaRepository<Sales,String> {
//    Set<Sales>getAll();
}
