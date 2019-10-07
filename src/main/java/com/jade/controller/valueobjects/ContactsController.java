package com.jade.controller.valueobjects;

import com.jade.domain.Contact;
import com.jade.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/invoicesystem/contact")
public class ContactsController {

    @Autowired
    private ContactService service;

    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Contact create(@RequestBody Contact contact) {
        return service.create(contact);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Contact update(@RequestBody Contact contact) {
        return service.update(contact);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @CrossOrigin(origins = "http://localhost:8383")
    @GetMapping(value = "/read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Contact read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping(value = "/read/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Contact> getAll() {
        return service.getAll();
    }
}
