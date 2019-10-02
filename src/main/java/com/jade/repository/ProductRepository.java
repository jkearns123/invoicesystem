package com.jade.repository;

import com.jade.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ProductRepository extends JpaRepository<Product,String> {
//    Set<Product>getAll();
}
