package com.jade.controller.valueobjects;

import com.jade.domain.Inventory;
import com.jade.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoicesystem/inventory")
public class InventoryController {

    @Autowired
    private InventoryService service;

    @CrossOrigin(origins = "http://localhost:8383")
    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE) //changed to consume
    public Inventory create(@RequestBody Inventory inventory){
        return service.create(inventory);
    }

    @CrossOrigin(origins = "http://localhost:8383")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Inventory update(@RequestBody Inventory inventory){
        return service.update(inventory);
    }

    @CrossOrigin(origins = "http://localhost:8383")
    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @CrossOrigin(origins = "http://localhost:8383")
    @GetMapping(value = "/read/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Inventory read(@PathVariable String id) {
        return service.read(id);
    }

    @CrossOrigin(origins = "http://localhost:8383")
    @GetMapping(value = "/read/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Inventory> getAll() {
        return service.getAll();
    }


}
