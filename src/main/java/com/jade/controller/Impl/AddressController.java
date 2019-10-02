package com.jade.controller.Impl;

import com.jade.domain.Address;
import com.jade.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    //@Qualifier("ContactServiceImpl")
    private AddressService service;

    @PostMapping("/create")
    @ResponseBody
    public Address create(@RequestBody Address address) {
        return service.create(address);
    }

    @PostMapping("/update")
    @ResponseBody
    public Address update(@RequestBody Address address) {
        return service.update(address);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Address read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public List<Address> getAll() {
        return service.getAll();
    }
}
