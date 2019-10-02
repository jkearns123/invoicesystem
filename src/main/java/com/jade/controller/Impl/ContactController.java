package com.jade.controller.Impl;

import com.jade.domain.Contact;
import com.jade.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService service;

    @PostMapping("/create")
    @ResponseBody
    public Contact create(@RequestBody Contact contact) {
        return service.create(contact);
    }

    @PutMapping("/update")
    @ResponseBody
    public Contact update(@RequestBody Contact contact) {
        return service.update(contact);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Contact read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public List<Contact> getAll() {
        return service.getAll();
    }
}
