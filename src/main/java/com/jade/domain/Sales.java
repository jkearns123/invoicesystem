package com.jade.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity(name = "sales")
public class Sales{


    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="sales_id")
    private String salesId;
    private double salesTotal;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Customer>customers;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Product> products;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = false)
    private List<User>users;

    private Sales() {
    }

    private Sales(Builder builder){
        this.salesId = builder.salesId;
        this.salesTotal = builder.salesTotal;
        this.products = builder.products;
        this.customers = builder.customers;
        this.users = builder.users;

    }

    public String getSalesId() {
        return salesId;
    }

    public double getSalesTotal() {
        return salesTotal;
    }

    public List<Product> getProducts(){return products;}

    public List<Customer> getCustomers(){return customers;}

    public List<User> getUsers(){return users;}

    public static class Builder{
        private String salesId;
        private double salesTotal;
        private List<Customer>customers;
        private List<Product> products;
        private List<User>users;

        public Builder salesId(String salesId) {
            this.salesId = salesId;
            return this;
        }

        public Builder salesTotal(double salesTotal) {
            this.salesTotal = salesTotal;
            return this;
        }

        public Builder products(Product product){
            this.products = (List<Product>) product;
            return this;
        }

        public Builder customers(Customer customer){
            this.customers = (List<Customer>) customer;
            return this;
        }

        public Builder users(User user){
            this.users = (List<User>) user;
            return this;
        }

        public Builder Copy(Sales sales){
            this.salesId = sales.salesId;
            this.salesTotal = sales.salesTotal;
            this.products = sales.products;
            this.customers = sales.customers;
            this.users = sales.users;

            return this;
        }

        public Sales build() {return new Sales(this);}
    }

    @Override
    public String toString() {
        return "Sales{" +
                "salesId='" + salesId + '\'' +
                ", salesTotal=" + salesTotal +
                ", customers=" + customers +
                ", products=" + products +
                ", users=" + users +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sales sales = (Sales) o;

        return salesId.equals(sales.salesId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salesId);
    }
}
