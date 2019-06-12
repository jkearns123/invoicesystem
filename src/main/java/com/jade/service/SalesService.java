package com.jade.service;

import com.jade.domain.Sales;

import java.util.Set;

public interface SalesService extends GenericService<Sales,String>{
    Set<Sales> getAll();
}
