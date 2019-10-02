package com.jade.service;

import com.jade.domain.Address;

import java.util.List;
import java.util.Set;

public interface AddressService extends GenericService<Address,String>{
    List<Address> getAll();
}
