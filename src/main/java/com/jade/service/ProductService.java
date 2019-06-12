package com.jade.service;

import com.jade.domain.Product;

import java.util.Set;

public interface ProductService extends GenericService<Product,String>{
    Set<Product> getAll();
}
