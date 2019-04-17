package com.jade.factory;


import com.jade.domain.Customer;
import com.jade.util.Miscellaneous;

public class CustomerFactory {
    public static Customer getCustomer(){
        return new Customer.Builder()
                .customerId(Miscellaneous.generateRandomId()).build();

    }
}
