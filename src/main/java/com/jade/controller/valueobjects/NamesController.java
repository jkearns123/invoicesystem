package com.jade.controller.valueobjects;

import com.jade.domain.Name;
import com.jade.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/invoicesystem/name")
public class NamesController {

    @Autowired
    private NameService service;

    @CrossOrigin(origins = "http://localhost:8383")
    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE) //changed to consume
    public Name create(@RequestBody Name name){
        return service.create(name);
    }

    @CrossOrigin(origins = "http://localhost:8383")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Name update(@RequestBody Name name){
        return service.update(name);
    }


    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @CrossOrigin(origins = "http://localhost:8383")
    @GetMapping(value = "/read/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Name read(@PathVariable String id) {
        return service.read(id);
    }


    @CrossOrigin(origins = "http://localhost:8383")
    @GetMapping(value = "/read/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Name> getAll() {
        return service.getAll();
    }
}
