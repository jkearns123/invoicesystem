package com.jade.domain;

import java.util.List;

public class Customer {
    private String customerId;
    private List<Product>products;
    private Name name;
    private Address address;
    private Contact contact;
    private Email email;

    private Customer() {
    }

    private Customer(Builder builder){
        this.customerId = builder.customerId;
        this.name = builder.name;
        this.address = builder.address;
        this.contact = builder.contact;
        this.email = builder.email;

    }

    public String getCustomerId() {
        return customerId;
    }

    public Name getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public Contact getContact() {
        return contact;
    }

    public Email getEmail() {
        return email;
    }

    public static class Builder{
        private String customerId;
        private List<Product>products;
        private Name name;
        private Address address;
        private Contact contact;
        private Email email;

        public Builder name(Name name){
            this.name = name;
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

        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }


        public Customer build(){return new Customer(this);}
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", products=" + products +
                ", name=" + name +
                ", address=" + address +
                ", contact=" + contact +
                ", email=" + email +
                '}';
    }
}
