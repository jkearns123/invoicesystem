package com.jade.factory;

import com.jade.domain.Product;
import com.jade.util.Miscellaneous;

public class ProductFactory {
    public static Product getProduct(String productName, int productQuantity, double price){
        return new Product.Builder().productName(productName).productQuantity(productQuantity).price(price).productId(Miscellaneous.generateRandomId()).build();
    }
}