package com.jade.controller.valueobjects;

import com.jade.domain.Email;
import com.jade.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/invoicesystem/email")
public class EmailsController {

    @Autowired
    @Qualifier("EmailServiceImpl")
    private EmailService service;

    @PostMapping(value = "/create",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Email create(@RequestBody Email email){
        return service.create(email);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Email update(@RequestBody Email email) {

        return service.update(email);
    }

    @DeleteMapping(value = "/delete/{emailId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable String emailId) {
        service.delete(emailId);

    }

    @GetMapping(value = "/read/{emailId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Email read(@PathVariable String emailId) {
        return service.read(emailId);
    }

    @GetMapping(value = "/read/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Set<Email> getAll() {
        return service.getAll();
    }
}
