package com.jade.domain;


import java.util.Set;

public class Supplier implements Comparable<Supplier>{
    private String supplierId, supplierName;
    private Set<Product> products;
    private Contact contact;
    private Address address;
    private Email email;

    private Supplier() {
    }

    private Supplier(Builder builder){
        this.supplierId = builder.supplierId;
        this.supplierName = builder.supplierName;
        this.contact = builder.contact;
        this.address = builder.address;
        this.email = builder.email;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public Contact getContact() {
        return contact;
    }

    public Address getAddress() {
        return address;
    }

    public Email getEmail() {
        return email;
    }

    @Override
    public int compareTo(Supplier o) {
        return this.supplierId.compareTo(o.supplierId);
    }

    public static class Builder {
        private String supplierId, supplierName;
        private Set<Product> products;
        private Contact contact;
        private Address address;
        private Email email;

        public Builder supplierId(String supplierId) {
            this.supplierId = supplierId;
            return this;
        }

        public Builder supplierName(String supplierName) {
            this.supplierName = supplierName;
            return this;
        }

        public Builder address(Address address){
            this.address = address;
            return this;
        }

        public Builder contact(Contact contact){
            this.contact = contact;
            return this;
        }

        public Builder email(Email email){
            this.email = email;
            return this;
        }

        public Builder Copy(Supplier supplier){
            this.supplierId = supplier.supplierId;
            this.supplierName = supplier.supplierName;
            this.contact = supplier.contact;
            this.address = supplier.address;
            this.email = supplier.email;

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
                ", contact=" + contact +
                ", address=" + address +
                ", email=" + email +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Supplier supplier = (Supplier) o;

        return supplierId.equals(supplier.supplierId);
    }

    @Override
    public int hashCode() {
        return supplierId.hashCode();
    }
}
