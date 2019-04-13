package com.jade.factory;

import com.jade.domain.Supplier;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SupplierFactoryTest {

    String supplierName = "Unilever";
    String supplierContact = "0860572908";
    String supplierAddress = "Unilever House 100 Victoria Embankment London";
    String supplierEmail = "consumer.affairs-za@unilever.com";

    Supplier supplier = SupplierFactory.getSupplier(supplierName,supplierContact,supplierAddress,supplierEmail);

    @Test
    public void getSupplierTestName() {

        Assert.assertEquals("Unilever",supplier.getSupplierName());
    }

    @Test
    public void getSupplierTestContact() {

        Assert.assertEquals("0860572908",supplier.getSupplierContact());
    }

    @Test
    public void getSupplierTestAddress() {

        Assert.assertEquals("Unilever House 100 Victoria Embankment London",supplier.getSupplierAddress());
    }

    @Test
    public void getSupplierTestEmail() {

        Assert.assertEquals("consumer.affairs-za@unilever.com",supplier.getSupplierEmail());
    }

    @Test
    public void getSupplierTestID() {

        assertNotNull(supplier.getSupplierId());
    }
}