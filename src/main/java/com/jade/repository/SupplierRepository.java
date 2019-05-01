package com.jade.repository;

import com.jade.domain.Supplier;

import java.util.Set;

public interface SupplierRepository extends GenericRepository<Supplier,String>{

/*    Supplier create(Supplier supplier);
    Supplier update(Supplier supplier);
    void delete(Supplier supplier);
    Supplier read(String supplierId);*/

    Set<Supplier> getAll();
}
