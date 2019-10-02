package com.jade.controller.supplier;

import com.jade.domain.Supplier;
import com.jade.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/invoicesystem/supplier")
public class SuppliersController {

    @Autowired
    private SupplierService service;

    @PostMapping(value = "/create",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Supplier create(@RequestBody Supplier supplier) {
        return service.create(supplier);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Supplier update(@RequestBody Supplier supplier) {
        return service.update(supplier);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping(value = "/read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Supplier read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping(value = "/read/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Supplier> getAll() {
        return service.getAll();
    }
}
