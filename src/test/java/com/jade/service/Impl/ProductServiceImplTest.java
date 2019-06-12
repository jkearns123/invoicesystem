package com.jade.service.Impl;

import com.jade.domain.Product;
import com.jade.factory.ProductFactory;
import com.jade.repository.impl.ProductRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder
        (MethodSorters.NAME_ASCENDING)
public class ProductServiceImplTest {

    private ProductRepositoryImpl repository;
    private Product product;

    String productName = "Marmite";
    int productQuantity = 3;
    double price = 25.00;

    private Product getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ProductRepositoryImpl.getRepository();
        this.product = ProductFactory.getProduct(productName,productQuantity,price);
    }

    @Test
    public void dGetAll() {
        Set<Product> products = this.repository.getAll();
        System.out.println("In getall, all: " + products);

        Assert.assertEquals(1,this.repository.getAll().size());
    }

    @Test
    public void aCreate() {
        Product createProduct = this.repository.create(this.product);
        System.out.println("In create, created: " + createProduct);

        Assert.assertNotNull(createProduct);

        Assert.assertSame(createProduct, this.product);
    }

    @Test
    public void cUpdate() {
        double newPrice = 50.00;
        Product updated = new Product.Builder().Copy(getSaved()).price(newPrice).build();
        System.out.println("In update, updated: " + updated);
        this.repository.update(updated);

        Assert.assertEquals(newPrice,updated.getPrice(),0.00);

    }

    @Test
    public void bRead() {
        Product savedProduct = getSaved();
        Product read = this.repository.read(savedProduct.getProductId());
        System.out.println("In read, read = " + read);

        Assert.assertSame(read,savedProduct);
    }

    @Test
    public void eDelete() {
        Product saved = getSaved();
        this.repository.delete(saved.getProductId());

        System.out.println("In array after delete: " + repository.getAll());

        Assert.assertEquals(0,this.repository.getAll().size());
    }
}