package com.jade.factory;

import com.jade.domain.Product;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductFactoryTest {

    String productName = "Marmite";
    int productQuantity = 6;
    double price = 18.99;

    Product product = ProductFactory.getProduct(productName,productQuantity,price);

    @Test
    public void getProductTestName() {

        Assert.assertEquals("Marmite",product.getProductName());
    }

    @Test
    public void getProductTestQuantity() {

        Assert.assertEquals(6,product.getProductQuantity());
    }

    @Test
    public void getProductTestPrice() {

        Assert.assertEquals(18.99,product.getPrice(),19.00);
    }

    @Test
    public void getProductTestID() {

        assertNotNull(product.getProductId());
    }
}