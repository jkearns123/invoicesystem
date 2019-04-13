package com.jade.factory;

import com.jade.domain.Customer;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerFactoryTest {
    String customerFirstName = "Atlas";
    String customerLastName = "Mulligan";
    String customerAddress = "37 Chelmsford court Vredehoek Cape Town";
    String customerContact = "0214661513";
    String customerEmail = "AtlMulligan@gmail.com";

    Customer customer = CustomerFactory.getCustomer(customerFirstName, customerLastName, customerAddress, customerContact, customerEmail);

    @Test
    public void getCustomerTestFirstName() {

        Assert.assertEquals("Atlas",customer.getCustomerFirstName());
    }

    @Test
    public void getCustomerTestLastName() {

        Assert.assertEquals("Mulligan",customer.getCustomerLastName());
    }

    @Test
    public void getCustomerTestAddress() {

        Assert.assertEquals("37 Chelmsford court Vredehoek Cape Town",customer.getCustomerAddress());
    }

    @Test
    public void getCustomerTestContact() {

        Assert.assertEquals("0214661513",customer.getCustomerContact());
    }

    @Test
    public void getCustomerTestEmail() {

        Assert.assertEquals("AtlMulligan@gmail.com",customer.getCustomerEmail());
    }

    @Test
    public void getCustomerTestID(){
        assertNotNull(customer.getCustomerId());
    }
}