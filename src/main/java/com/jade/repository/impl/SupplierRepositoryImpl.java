package com.jade.repository.impl;

import com.jade.domain.Supplier;
import com.jade.repository.SupplierRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("InMemory7")
public class SupplierRepositoryImpl implements SupplierRepository {

    private static SupplierRepositoryImpl repository = null;
    private Set<Supplier> suppliers;

    private SupplierRepositoryImpl(){
        this.suppliers = new HashSet<>();
    }

    public static SupplierRepositoryImpl getRepository(){
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
        Supplier supplier = findSupplier(supplierId);
        return supplier;
    }

    public Supplier update(Supplier supplier){
        Supplier toDelete = findSupplier(supplier.getSupplierId());
        if(toDelete != null){
            this.suppliers.remove(toDelete);
            return create(supplier);
        }
        return null;
    }

    public Set<Supplier> getAll(){
        return this.suppliers;
    }


}
