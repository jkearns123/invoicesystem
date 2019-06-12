package com.jade.controller.Impl;

import com.jade.domain.Customer;
import com.jade.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    @Qualifier("CustomerServiceImpl")
    private CustomerService service;

    @PostMapping("/create")
    @ResponseBody
    public Customer create(@RequestBody Customer customer) {
        return service.create(customer);
    }

    @PostMapping("/update")
    @ResponseBody
    public Customer update(@RequestBody Customer customer) {
        return service.update(customer);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Customer read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Customer> getAll() {
        return service.getAll();
    }
}
