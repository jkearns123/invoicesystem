package com.jade.controller.user;

import com.jade.domain.Sales;
import com.jade.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/invoicesystem/sales")
public class SalessController {

    @Autowired
    private SalesService service;

    @PostMapping(value = "/create",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Sales create(@RequestBody Sales sales) {
        return service.create(sales);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Sales update(@RequestBody Sales sales) {
        return service.update(sales);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping(value = "/read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Sales read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping(value = "/read/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Sales> getAll() {
        return service.getAll();
    }
}
