package com.jade.controller.products;

import com.jade.domain.Product;
import com.jade.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/invoicesystem/product")
public class ProductsController {

    @Autowired
    private ProductService service;

    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Product create(@RequestBody Product product) {

        return service.create(product);
    }

    @GetMapping(value = "/read/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Product> getAll() {
        return service.getAll();
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Product update(@RequestBody Product product) {
        return service.update(product);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping(value = "/read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product read(@PathVariable String id) {
        return service.read(id);
    }

}
