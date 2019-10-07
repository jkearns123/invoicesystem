package com.jade.controller.valueobjects;

import com.jade.domain.Address;
import com.jade.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/invoicesystem/address")
public class AddressesController {

    @Autowired
    private AddressService service;

    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Address create(@RequestBody Address address) {
        return service.create(address);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Address update(@RequestBody Address address) {
        return service.update(address);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @CrossOrigin(origins = "http://localhost:8383")
    @GetMapping(value = "/read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Address read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping(value = "/read/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Address> getAll() {
        return service.getAll();
    }
}
