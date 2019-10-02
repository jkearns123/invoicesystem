package com.jade.repository;

import com.jade.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface UserRepository extends JpaRepository<User,String> {
//    Set<User>getAll();
}
