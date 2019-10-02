package com.jade.controller.customer;

import com.jade.domain.Customer;
import com.jade.domain.helper.ResponseObj;
import com.jade.factory.helper.ResponseObjFactory;
import com.jade.service.CustomerService;
import com.jade.service.Impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/invoicesystem/customer")
public class CustomersController {

    @Autowired
    private CustomerService service;

    @PostMapping(value = "/create",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Customer create(@RequestBody Customer customer) {
        return service.create(customer);
    }

    @GetMapping(value = "/read/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Customer> getAll() {
        return service.getAll();
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Customer update(@RequestBody Customer customer) {
        return service.update(customer);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping(value = "/read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Customer read(@PathVariable String id) {
        return service.read(id);
    }
}
