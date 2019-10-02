package com.jade.repository;

import com.jade.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface SupplierRepository extends JpaRepository<Supplier,String> {

//    Set<Supplier> getAll();
}
