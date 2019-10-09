package com.jade.factory;

import com.jade.domain.Inventory;

public class InventoryFactory {
    public static Inventory getInventory(String productDescription, double productPrice){
        return new Inventory.Builder().productDescription(productDescription).productPrice(productPrice).build();
    }
}
