package com.jade.repository.impl;

import com.jade.domain.Sales;
import com.jade.factory.SalesFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

//The FixMethodOrder class allows the user to choose the order of execution of the methods within a test class
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SalesRepositoryImplTest {

    private SalesRepositoryImpl repository;
    private Sales sales;

    private Sales getTestSales(){
        double testSalesTotal = 65.90;

        return SalesFactory.getSales(testSalesTotal);
    }

    private Sales getSavedSales(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = (SalesRepositoryImpl) SalesRepositoryImpl.getRepository();
        this.sales = getTestSales();
    }

    @Test
    public void aCreate() {
        Sales savedSales = this.repository.create(this.sales);
        System.out.println("Created record:\n**************");
        System.out.println(savedSales);
        Assert.assertNotNull(savedSales);
    }



    @Test
    public void bRead() {
        Sales testSales = getSavedSales();
        Sales readSaled = this.repository.read(testSales.getSalesId());
        System.out.println("Read record:\n**************");
        System.out.println("Saved Record: " + testSales);
        System.out.println("Read Record: " + readSaled);
        Assert.assertSame(testSales,readSaled);
    }

    @Test
    public void cUpdate() {
        double updateSalesTotal = 100.56;

        Sales sales = getSavedSales();
        Sales copyOfSales = new Sales.Builder().Copy(sales).salesTotal(updateSalesTotal).build();
        Sales updatedSales = this.repository.update(copyOfSales);

        System.out.println("Update record:\n**************");
        System.out.println("Previous Record: " + sales);
        System.out.println("Updated Record: " + updatedSales);

        Assert.assertNotNull(updatedSales);
        Assert.assertNotEquals(sales.getSalesTotal(),updatedSales.getSalesTotal());
    }

    @Test
    public void dGetAll() {
        System.out.println("Get all records:\n**************");
        System.out.println(this.repository.getAll());
        Assert.assertNotNull(this.repository.getAll());
    }

    @Test
    public void eDelete() {
        Sales sales = getSavedSales();
        this.repository.delete(sales.getSalesId());

        System.out.println("Delete record:\n**************");
        System.out.println("Current record: " + sales);
        System.out.println("Deleted: " + this.repository.getAll());
        Assert.assertEquals(0,this.repository.getAll().size());
    }
}