package com.jade.factory;

import com.jade.domain.Customer;
import com.jade.domain.Product;
import com.jade.domain.Sales;
import com.jade.domain.User;
import com.jade.util.Miscellaneous;

public class SalesFactory {
    public static Sales getSales(double salesTotal, Product product, Customer customer, User user){
        return new Sales.Builder().salesTotal(salesTotal).products(product).customers(customer).users(user)
                .salesId(Miscellaneous.generateRandomId()).build();
    }
}