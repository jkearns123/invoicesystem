package com.jade.repository;

import com.jade.domain.Product;

import java.util.Set;

public interface ProductRepository extends GenericRepository<Product,String>{

/*    Product read(String productId);    Product create(Product product);
    Product update(Product product);
    void delete(Product product);*/

    Set<Product>getAll();

}
