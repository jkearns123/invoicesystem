package com.jade.repository;

import com.jade.domain.Sales;

import java.util.Set;

public interface SalesRepository extends GenericRepository<Sales,String>{

/*    Sales create(Sales sales);
    Sales update(Sales sales);
    void delete(Sales sales);
    Sales read(String salesId);*/

    Set<Sales>getAll();
}
