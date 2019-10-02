package com.jade.service.Impl;

import com.jade.domain.Product;
import com.jade.repository.ProductRepository;
import com.jade.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    private static ProductService service = null;

    @Autowired
    private ProductRepository repository;


    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product create(Product product) {
        return this.repository.save(product);
    }

    @Override
    public Product update(Product product) {
        return this.repository.save(product);
    }

    @Override
    public Product read(String s) {
        Optional<Product> opt = this.repository.findById(s);
        return opt.orElse(null);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }
}
