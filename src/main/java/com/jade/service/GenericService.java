package com.jade.service;

import java.util.Set;

public interface GenericService<T, ID> {
    //T is the generic Entity that gets parsed eg. Customer
    //ID is the ID of the Entity that identifies the entity eg. customerId
    T create(T t);
    T update(T t);
    T read(ID id);
    void delete(ID id);
}
