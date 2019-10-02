package com.jade.service.Impl;

import com.jade.domain.User;
import com.jade.repository.UserRepository;
import com.jade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private static UserService service = null;

    @Autowired
    private UserRepository repository;


    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User create(User user) {
        return this.repository.save(user);
    }

    @Override
    public User update(User user) {
        return this.repository.save(user);
    }

    @Override
    public User read(String s) {
        Optional<User> opt = this.repository.findById(s);
        return opt.orElse(null);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }
}
