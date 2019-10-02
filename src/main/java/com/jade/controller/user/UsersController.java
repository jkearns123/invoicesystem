package com.jade.controller.user;

import com.jade.domain.User;
import com.jade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/invoicesystem/user")
public class UsersController {

    @Autowired
    private UserService service;

    @PostMapping(value = "/create",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User create(@RequestBody User user) {
        return service.create(user);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User update(@RequestBody User user) {
        return service.update(user);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping(value = "/read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping(value = "/read/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<User> getAll() {
        return service.getAll();
    }
}
