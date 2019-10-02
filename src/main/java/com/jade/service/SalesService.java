package com.jade.service;

import com.jade.domain.Sales;

import java.util.List;
import java.util.Set;

public interface SalesService extends GenericService<Sales,String>{
    List<Sales> getAll();
}
