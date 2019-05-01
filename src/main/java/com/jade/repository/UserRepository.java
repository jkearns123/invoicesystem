package com.jade.repository;

import com.jade.domain.User;

import java.util.Set;

public interface UserRepository extends GenericRepository<User,String>{

/*    User create(User user);
    User update(User user);
    void delete(User user);
    User read(String userId);*/

    Set<User>getAll();
}
