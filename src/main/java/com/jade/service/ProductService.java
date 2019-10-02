package com.jade.service;

import com.jade.domain.Product;

import java.util.List;
import java.util.Set;

public interface ProductService extends GenericService<Product,String>{
    List<Product> getAll();
}
