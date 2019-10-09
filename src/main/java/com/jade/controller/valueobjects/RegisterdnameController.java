package com.jade.controller.valueobjects;

import com.jade.domain.Registerdname;
import com.jade.service.RegisterdnameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoicesystem/registerdname")
public class RegisterdnameController {

    @Autowired
    private RegisterdnameService service;

    @CrossOrigin(origins = "http://localhost:8383")
    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE) //changed to consume
    public Registerdname create(@RequestBody Registerdname registerdname){
        return service.create(registerdname);
    }

    @CrossOrigin(origins = "http://localhost:8383")
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Registerdname update(@RequestBody Registerdname registerdname){
        return service.update(registerdname);
    }


    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @CrossOrigin(origins = "http://localhost:8383")
    @GetMapping(value = "/read/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Registerdname read(@PathVariable String id) {
        return service.read(id);
    }


    @CrossOrigin(origins = "http://localhost:8383")
    @GetMapping(value = "/read/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Registerdname> getAll() {
        return service.getAll();
    }
}
