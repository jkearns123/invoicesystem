package com.jade.controller.Impl;

import com.jade.domain.Name;
import com.jade.factory.NameFactory;
import com.jade.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/name")
public class NameController {
    @Autowired
    private NameService service;

   /* @PostMapping("/create/{firstName}/{lastName}")
    public Name create(@PathVariable String firstName, @PathVariable String lastName){
        Name name = NameFactory.getName(firstName,lastName);
        return service.create(name);}*/
    @PostMapping("/create")
    @ResponseBody
    public Name create(@RequestBody Name name){
        return service.create(name);
    }

    @PostMapping("/update")
    @ResponseBody
    public Name update(@RequestBody Name name){
        return service.update(name);
    }


/*    @PutMapping("/update/{nameId}")
    @ResponseBody
    public Name update(@PathVariable String nameId, @RequestBody Name name) {

        return service.update(name);
    }*/

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Name read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public List<Name> getAll() {
        return service.getAll();
    }
}
