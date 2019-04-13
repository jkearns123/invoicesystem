package com.jade.factory;

import com.jade.domain.Supplier;
import com.jade.util.Miscellaneous;

public class SupplierFactory {
    public static Supplier getSupplier(String supplierName, String supplierContact, String supplierAddress, String supplierEmail){
        return new Supplier.Builder().supplierName(supplierName)
                .supplierContact(supplierContact)
                .supplierAddress(supplierAddress)
                .supplierEmail(supplierEmail)
                .supplierId(Miscellaneous.generateRandomId())
                .build();
    }
}