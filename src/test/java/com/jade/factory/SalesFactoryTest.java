//package com.jade.factory;
//
//import com.jade.domain.Sales;
//import org.junit.Assert;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class SalesFactoryTest {
//
//    double salesTotal = 113.94;
//
//    Sales sales = SalesFactory.getSales(salesTotal);
//
//    @Test
//    public void getSalesTestTotal() {
//
//        Assert.assertEquals(113.94,sales.getSalesTotal(),113.95);
//    }
//
//    @Test
//    public void getSalesTestID() {
//        System.out.println(sales.getSalesId());
//
//        assertNotNull(sales.getSalesId());
//    }
//}