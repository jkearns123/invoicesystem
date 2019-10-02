package com.jade.controller.Impl;

import com.jade.domain.Product;
import com.jade.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping("/create")
    @ResponseBody
    public Product create(@RequestBody Product product) {
        return service.create(product);
    }

    @PostMapping("/update")
    @ResponseBody
    public Product update(@RequestBody Product product) {
        return service.update(product);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Product read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public List<Product> getAll() {
        return service.getAll();
    }
}
