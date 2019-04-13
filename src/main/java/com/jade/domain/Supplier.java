package com.jade.domain;


import java.util.Set;

public class Supplier {
    private String supplierId, supplierName, supplierContact, supplierAddress, supplierEmail;
    private Set<Product> products;

    private Supplier() {
    }

    private Supplier(Builder builder){
        this.supplierId = builder.supplierId;
        this.supplierName = builder.supplierName;
        this.supplierContact = builder.supplierContact;
        this.supplierAddress = builder.supplierAddress;
        this.supplierEmail = builder.supplierEmail;

    }

    public String getSupplierId() {
        return supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getSupplierContact() {
        return supplierContact;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public static class Builder {
        private String supplierId, supplierName, supplierContact, supplierAddress, supplierEmail;
        private Set<Product> products;

        public Builder supplierId(String supplierId) {
            this.supplierId = supplierId;
            return this;
        }

        public Builder supplierName(String supplierName) {
            this.supplierName = supplierName;
            return this;
        }

        public Builder supplierContact(String supplierContact) {
            this.supplierContact = supplierContact;
            return this;
        }

        public Builder supplierAddress(String supplierAddress){
            this.supplierAddress = supplierAddress;
            return this;
        }

        public Builder supplierEmail(String supplierEmail){
            this.supplierEmail = supplierEmail;
            return this;
        }

        public Supplier build(){
            return new Supplier(this);
        }
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId='" + supplierId + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ", supplierContact='" + supplierContact + '\'' +
                ", supplierAddress='" + supplierAddress + '\'' +
                ", supplierEmail='" + supplierEmail + '\'' +
                '}';
    }
}
