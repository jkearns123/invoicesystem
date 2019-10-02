package com.jade.factory;

import com.jade.domain.Supplier;
import com.jade.domain.*;
import com.jade.util.Miscellaneous;

public class SupplierFactory {
    public static Supplier getSupplier(String supplierName,Contact contact,Address address, Email email, Product product){
        return new Supplier.Builder().supplierName(supplierName).contact(contact).address(address).email(email).products(product)
                .supplierId(Miscellaneous.generateRandomId())
                .build();
    }
}