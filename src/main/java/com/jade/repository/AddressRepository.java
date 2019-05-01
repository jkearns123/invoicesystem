package com.jade.repository;

import com.jade.domain.Address;

import java.util.Set;

public interface AddressRepository extends GenericRepository<Address,String>{
    Set<Address> getAll();
}
