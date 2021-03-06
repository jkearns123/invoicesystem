package com.jade.factory;


import com.jade.domain.Customer;
import com.jade.domain.*;
import com.jade.util.Miscellaneous;

public class CustomerFactory {
    public static Customer getCustomer(Name name,Address address,Contact contact,Email email, Product product){
        return new Customer.Builder().name(name).address(address).contact(contact).email(email).products(product)
                .customerId(Miscellaneous.generateRandomId()).build();


    }
}
