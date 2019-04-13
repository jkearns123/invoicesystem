package com.jade.factory;


import com.jade.domain.Customer;
import com.jade.util.Miscellaneous;

public class CustomerFactory {
    public static Customer getCustomer(String customerFirstName, String customerLastName, String customerAddress, String customerContact, String customerEmail){
        return new Customer.Builder().customerFirstName(customerFirstName)
                .customerLastName(customerLastName)
                .customerAddress(customerAddress)
                .customerContact(customerContact)
                .customerEmail(customerEmail)
                .customerId(Miscellaneous.generateRandomId()).build();

    }
}
