package com.jade.service.Impl;

import com.jade.domain.User;
import com.jade.repository.UserRepository;
import com.jade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("InMemory8")
    private UserRepository repository;


    @Override
    public Set<User> getAll() {
        return repository.getAll();
    }

    @Override
    public User create(User user) {
        return repository.create(user);
    }

    @Override
    public User update(User user) {
        return repository.update(user);
    }

    @Override
    public User read(String s) {
        return repository.read(s);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }
}
