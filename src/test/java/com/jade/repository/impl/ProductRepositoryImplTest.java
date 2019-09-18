package com.jade.repository.impl;

import com.jade.domain.Product;
import com.jade.factory.ProductFactory;
import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

//The FixMethodOrder class allows the user to choose the order of execution of the methods within a test class
@FixMethodOrder
        (MethodSorters.NAME_ASCENDING)
public class ProductRepositoryImplTest {

    private ProductRepositoryImpl repository;
    private Product product;

    private Product getTestProduct(){
        String testProductName = "Marmite 250g";
        int testProductQuantity = 6;
        double testProductPrice = 13.50;

        return ProductFactory.getProduct(testProductName,testProductQuantity,testProductPrice);
    }

    private Product getSavedProducts(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = (ProductRepositoryImpl) ProductRepositoryImpl.getRepository();
        this.product = getTestProduct();
    }

    @Test
    public void aCreate() {
        Product savedProduct = this.repository.create(this.product);

        System.out.println("Created record:\n**************");
        System.out.println(savedProduct);
        Assert.assertNotNull(savedProduct);
    }


    @Test
    public void bRead() {
        Product testProduct = getSavedProducts();
        Product readProduct = this.repository.read(testProduct.getProductId());
        System.out.println("Read record:\n**************");
        System.out.println("Saved Record: " + testProduct);
        System.out.println("Read Record: " + readProduct);
        Assert.assertSame(testProduct,readProduct);
    }

    @Test
    public void cUpdate() {
        double updateProductPrice = 16.99;
        String updateProductName = "Marmite 500g";

        Product product = getSavedProducts();
        Product copyOfProduct = new Product.Builder().Copy(product).price(updateProductPrice).productName(updateProductName).build();
        Product updatedProducts = this.repository.update(copyOfProduct);

        System.out.println("Update record:\n**************");
        System.out.println("Previous Record: " + product.getProductName() + " " + product.getPrice());
        System.out.println("Updated Record: " + updatedProducts.getProductName() + " " + updatedProducts.getPrice());
        Assert.assertNotNull(updatedProducts);
        Assert.assertNotEquals(product.getPrice(),updatedProducts.getPrice());
        Assert.assertNotEquals(product.getProductName(),updatedProducts.getProductName());

        System.out.println("In Array; " + repository.getAll());
    }

    @Test
    public void dGetAll() {
        System.out.println("Get all records:\n**************");
        System.out.println(this.repository.getAll());
        Assert.assertNotNull(this.repository.getAll());
    }

    @Test
    public void eDelete() {
        Product product = getSavedProducts();
        this.repository.delete(product.getProductId());

        System.out.println("Delete record:\n**************");
        System.out.println("Current record: " + product);
        System.out.println("Deleted: " + this.repository.getAll());

        Assert.assertEquals(0,this.repository.getAll().size());
    }
}