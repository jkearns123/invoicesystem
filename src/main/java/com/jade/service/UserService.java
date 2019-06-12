package com.jade.service;

import com.jade.domain.User;

import java.util.Set;

public interface UserService extends GenericService<User,String>{
    Set<User> getAll();
}
