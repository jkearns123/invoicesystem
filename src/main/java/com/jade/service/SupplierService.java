package com.jade.service;

import com.jade.domain.Supplier;

import java.util.List;
import java.util.Set;

public interface SupplierService extends GenericService<Supplier,String>{

    List<Supplier> getAll();
}
