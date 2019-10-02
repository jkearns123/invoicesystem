package com.jade.controller.Impl;

import com.jade.domain.Email;
import com.jade.factory.EmailFactory;
import com.jade.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailService service;

    @PostMapping("/create")
    @ResponseBody
    public Email create(@RequestBody  Email email){
        return service.create(email);
    }

    @PutMapping("/update")
    @ResponseBody
    public Email update(@RequestBody Email email) {

        return service.update(email);
    }

    @GetMapping("/delete/{emailId}")
    @ResponseBody
    public void delete(@PathVariable String emailId) {
        service.delete(emailId);

    }

    @GetMapping("/read/{emailId}")
    @ResponseBody
    public Email read(@PathVariable String emailId) {
        return service.read(emailId);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public List<Email> getAll() {
        return service.getAll();
    }

}
