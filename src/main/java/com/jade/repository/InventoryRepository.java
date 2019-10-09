package com.jade.repository;

import com.jade.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository <Inventory,String>{

}
