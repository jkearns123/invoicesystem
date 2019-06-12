package com.jade.repository.impl;

import com.jade.domain.User;
import com.jade.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("InMemory8")
public class UserRepositoryImpl implements UserRepository{

    //singleton
    //make sure to use UserRepositoryImpl

    private static UserRepositoryImpl repository = null;
    private Set<User> users;

    private UserRepositoryImpl(){
        this.users = new HashSet<>();
    }

    //make sure to use UserRepositoryImpl
    public static UserRepositoryImpl getRepository(){
        if(repository == null) repository = new UserRepositoryImpl();
        return repository;
    }

    private User findUser(final String userId){
        for(User u : this.users){
            if(u.getUserId().equals(userId)) return u;
        }
        return null;
        //return this.users.stream().filter(user -> user.getUserId().equals(userId)).findAny().orElse(null);
    }

    public User create(User user){
        this.users.add(user);
        return user;
    }

    public void delete(String userId){
        User user = findUser(userId);
        if (user != null)
        this.users.remove(user);
    }

    public User read(final String userId){
        User user = findUser(userId);
        return user;
    }

    public User update(User user){
        User toDelete = findUser(user.getUserId());
        if(toDelete != null){
            this.users.remove(toDelete);
            return create(user);
        }
        return null;
    }

    public Set<User> getAll(){
        return this.users;
    }
}
