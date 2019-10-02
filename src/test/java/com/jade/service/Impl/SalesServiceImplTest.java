//package com.jade.service.Impl;
//
//import com.jade.domain.Sales;
//import com.jade.factory.SalesFactory;
//import com.jade.repository.impl.SalesRepositoryImpl;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//
//import java.util.Set;
//
//import static org.junit.Assert.*;
//
//@FixMethodOrder
//        (MethodSorters.NAME_ASCENDING)
//public class SalesServiceImplTest {
//
//    private SalesRepositoryImpl repository;
//    private Sales sales;
//
//    double salesTotal = 20.55;
//
//    private Sales getSaved(){
//        return this.repository.getAll().iterator().next();
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        this.repository = SalesRepositoryImpl.getRepository();
//        this.sales = SalesFactory.getSales(salesTotal);
//    }
//
//    @Test
//    public void dGetAll() {
//        Set<Sales> saless = this.repository.getAll();
//        System.out.println("In getall, all: " + saless);
//
//        Assert.assertEquals(1,this.repository.getAll().size());
//
//    }
//
//    @Test
//    public void aCreate() {
//        Sales createSale = this.repository.create(this.sales);
//        System.out.println("In create, created: " + createSale);
//
//        Assert.assertNotNull(createSale);
//
//        Assert.assertSame(createSale, this.sales);
//    }
//
//    @Test
//    public void cUpdate() {
//        double newSaleT = 50.05;
//        Sales updated = new Sales.Builder().Copy(getSaved()).salesTotal(newSaleT).build();
//        System.out.println("In update, updated: " + updated);
//        this.repository.update(updated);
//
//        Assert.assertEquals(newSaleT,updated.getSalesTotal(),0.00);
//    }
//
//    @Test
//    public void bRead() {
//        Sales savedSales = getSaved();
//        Sales read = this.repository.read(savedSales.getSalesId());
//        System.out.println("In read, read = " + read);
//
//        Assert.assertSame(read,savedSales);
//    }
//
//    @Test
//    public void eDelete() {
//        Sales saved = getSaved();
//        this.repository.delete(saved.getSalesId());
//
//        System.out.println("In array after delete: " + repository.getAll());
//
//        Assert.assertEquals(0,this.repository.getAll().size());
//    }
//}