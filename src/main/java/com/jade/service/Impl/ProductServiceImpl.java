package com.jade.service.Impl;

import com.jade.domain.Product;
import com.jade.repository.ProductRepository;
import com.jade.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("ProductServiceImpl")
public class ProductServiceImpl implements ProductService {

    @Autowired
    @Qualifier("InMemory6")
    private ProductRepository repository;


    @Override
    public Set<Product> getAll() {
        return repository.getAll();
    }

    @Override
    public Product create(Product product) {
        return repository.create(product);
    }

    @Override
    public Product update(Product product) {
        return repository.update(product);
    }

    @Override
    public Product read(String s) {
        return repository.read(s);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }
}
