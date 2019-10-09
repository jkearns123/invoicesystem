package com.jade.service;

import com.jade.domain.Inventory;

import java.util.List;

public interface InventoryService extends GenericService<Inventory,String>{
    List<Inventory> getAll();
}
