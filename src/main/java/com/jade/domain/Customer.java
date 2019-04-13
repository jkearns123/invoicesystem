package com.jade.domain;

import java.util.List;

public class Customer {
    private String customerId, customerFirstName, customerLastName, customerAddress, customerContact, customerEmail;
    private List<Product>products;

    private Customer() {
    }

    private Customer(Builder builder){
        this.customerId = builder.customerId;
        this.customerFirstName = builder.customerFirstName;
        this.customerLastName = builder.customerLastName;
        this.customerAddress = builder.customerAddress;
        this.customerContact = builder.customerContact;
        this.customerEmail = builder.customerEmail;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public static class Builder{
        private String customerId, customerFirstName, customerLastName, customerAddress, customerContact, customerEmail;
        private List<Product>products;

        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder customerFirstName(String customerFirstName) {
            this.customerFirstName = customerFirstName;
            return this;
        }

        public Builder customerLastName(String customerLastName) {
            this.customerLastName = customerLastName;
            return this;
        }

        public Builder customerAddress(String customerAddress) {
            this.customerAddress = customerAddress;
            return this;
        }

        public Builder customerContact(String customerContact) {
            this.customerContact = customerContact;
            return this;
        }

        public Builder customerEmail(String customerEmail) {
            this.customerEmail = customerEmail;
            return this;
        }

        public Customer build(){return new Customer(this);}
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerContact='" + customerContact + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                '}';
    }
}
