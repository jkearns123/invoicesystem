package com.jade.repository;

public interface GenericRepository <T, ID>{
    //T is the generic Entity that gets parsed eg. Customer
    //ID is the ID of the Entity that identifies the entity eg. customerId
    T create(T t);
    T update(T t);
    void delete(ID id);
    T read(ID id);
}
