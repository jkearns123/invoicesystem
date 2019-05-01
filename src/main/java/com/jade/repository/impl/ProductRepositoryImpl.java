package com.jade.repository.impl;

import com.jade.domain.Product;
import com.jade.repository.ProductRepository;

import java.util.HashSet;
import java.util.Set;

public class ProductRepositoryImpl implements ProductRepository {

    //changed from private static ProductRepository repository = null;
    private static ProductRepositoryImpl repository = null;
    private Set<Product> prouducts;

    private ProductRepositoryImpl(){
        this.prouducts = new HashSet<>();
    }

    //changed from public static ProductRepository getRepository(){
    public static ProductRepository getRepository(){
        if(repository == null) repository = new ProductRepositoryImpl();
        return repository;
    }

    private Product findProduct(final String productId){
        for(Product p : this.prouducts){
            if(p.getProductId().equals(productId)) return p;
        }
        return null;
        //return this.prouducts.stream().filter(product -> product.getProductId().equals(productId)).findAny().orElse(null);
    }

    public Product create(Product product){
        this.prouducts.add(product);
        return product;
    }


    public void delete(String productId){
        Product product = findProduct(productId);
        if (product != null)
        this.prouducts.remove(product);
    }

    public Product read(final String productId){
        return findProduct(productId);
    }

    public Product update(Product product){
        Product p = findProduct(product.getProductId());
        if(p != null){
            Product pp = new Product.Builder().Copy(product).build();
            return create(pp);
        }
        return null;
    }

    public Set<Product> getAll(){
        return this.prouducts;
    }

}
