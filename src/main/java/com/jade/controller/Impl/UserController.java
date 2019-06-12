package com.jade.controller.Impl;

import com.jade.domain.User;
import com.jade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService service;

    @PostMapping("/create")
    @ResponseBody
    public User create(@RequestBody User user) {
        return service.create(user);
    }

    @PostMapping("/update")
    @ResponseBody
    public User update(@RequestBody User user) {
        return service.update(user);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public User read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<User> getAll() {
        return service.getAll();
    }
}
