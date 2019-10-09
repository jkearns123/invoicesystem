package com.jade.service;

import com.jade.domain.Registerdname;

import java.util.List;

public interface RegisterdnameService extends GenericService<Registerdname,String>{
    List<Registerdname> getAll();
}
