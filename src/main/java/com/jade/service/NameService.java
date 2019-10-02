package com.jade.service;

import com.jade.domain.Name;

import java.util.List;
import java.util.Set;

public interface NameService  extends GenericService<Name,String>{
    List<Name> getAll();
}
