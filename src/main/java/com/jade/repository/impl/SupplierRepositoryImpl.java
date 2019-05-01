package com.jade.repository.impl;

import com.jade.domain.Supplier;
import com.jade.repository.SupplierRepository;

import java.util.HashSet;
import java.util.Set;

public class SupplierRepositoryImpl implements SupplierRepository {

    private static SupplierRepositoryImpl repository = null;
    private Set<Supplier> suppliers;

    private SupplierRepositoryImpl(){
        this.suppliers = new HashSet<>();
    }

    public static SupplierRepository getRepository(){
        if(repository == null) repository = new SupplierRepositoryImpl();
        return repository;
    }

    private Supplier findSupplier(final String supplierId){
        for(Supplier s : this.suppliers){
            if(s.getSupplierId().equals(supplierId)) return s;
        }
        return null;
        //return this.suppliers.stream().filter(supplier -> supplier.getSupplierId().equals(supplierId)).findAny().orElse(null);
    }

    public Supplier create(Supplier supplier){
        this.suppliers.add(supplier);
        return supplier;
    }

    //changed from public void delete(Supplier supplier){
    public void delete(String supplierId){
        Supplier supplier = findSupplier(supplierId);
        if (supplier != null)
        this.suppliers.remove(supplier);
    }

    public Supplier read(final String supplierId){
        return findSupplier(supplierId);
    }

    public Supplier update(Supplier supplier){
        Supplier s = findSupplier(supplier.getSupplierId());
        if(s != null){
            Supplier ss = new Supplier.Builder().Copy(supplier).build();
            return create(ss);
        }
        return null;
    }

    public Set<Supplier> getAll(){
        return this.suppliers;
    }


}
