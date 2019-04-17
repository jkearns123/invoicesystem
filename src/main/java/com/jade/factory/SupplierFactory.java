package com.jade.factory;

import com.jade.domain.Supplier;
import com.jade.util.Miscellaneous;

public class SupplierFactory {
    public static Supplier getSupplier(String supplierName){
        return new Supplier.Builder().supplierName(supplierName)
                .supplierId(Miscellaneous.generateRandomId())
                .build();
    }
}