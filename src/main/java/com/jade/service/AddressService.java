package com.jade.service;

import com.jade.domain.Address;

import java.util.Set;

public interface AddressService extends GenericService<Address,String>{
    Set<Address> getAll();
}
