package com.jade.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity(name = "customer")
public class Customer{

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="customer_id")
    private String customerId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Product>products;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "name", referencedColumnName = "name_id")
    private Name name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address", referencedColumnName = "address_id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact", referencedColumnName = "contact_id")
    private Contact contact;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email", referencedColumnName = "email_id")
    private Email email;

    private Customer() {
    }

    private Customer(Builder builder){
        this.customerId = builder.customerId;
        this.name = builder.name;
        this.address = builder.address;
        this.contact = builder.contact;
        this.email = builder.email;
        this.products = builder.products;

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

    public List<Product> getProducts(){return products;}

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

        public Builder products(Product product){
            this.products = (List<Product>) product;
            return this;
        }

        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        //builder class prevents you from changing the contents of the class, so in order to change the content you make a copy of the class
        //with a new value and use a reference of that class
        public Builder Copy(Customer customer){
            this.customerId = customer.customerId;
            this.name = customer.name;
            this.address = customer.address;
            this.contact = customer.contact;
            this.email = customer.email;
            this.products = customer.products;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return customerId.equals(customer.customerId);
    }

    @Override
    public int hashCode() {
        return customerId.hashCode();
    }
}
