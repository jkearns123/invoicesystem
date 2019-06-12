package com.jade.repository.impl;

import com.jade.domain.Sales;
import com.jade.repository.SalesRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("InMemory9")
public class SalesRepositoryImpl implements SalesRepository {

    //changed from private static SalesRepository repository = null;
    private static SalesRepositoryImpl repository = null;
    private Set<Sales> saless;

    private SalesRepositoryImpl(){
        this.saless = new HashSet<>();
    }


    public static SalesRepositoryImpl getRepository(){
        if(repository == null) repository = new SalesRepositoryImpl();
        return repository;
    }

    private Sales findSales(final String salesId){
        for(Sales s : this.saless){
            if(s.getSalesId().equals(salesId)) return s;
        }
        return null;
        //return this.saless.stream().filter(sales -> sales.getSalesId().equals(salesId)).findAny().orElse(null);
    }

    public Sales create(Sales sales){
        this.saless.add(sales);
        return sales;
    }

    //changed from  public void delete(Sales sales){
    public void delete(String salesId){
        Sales sales = findSales(salesId);
        if (sales != null)
        this.saless.remove(sales);
    }

    public Sales read(final String salesId){
        Sales sales = findSales(salesId);
        return sales;
    }

    public Sales update(Sales sales){
        Sales toDelete = findSales(sales.getSalesId());
        if(toDelete != null){
            this.saless.remove(toDelete);
            return create(sales);
        }
        return null;
    }

    public Set<Sales> getAll(){
        return this.saless;
    }

}
