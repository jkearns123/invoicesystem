package com.jade.domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Sales{
    private String salesId;
    private double salesTotal;
    private Set<Customer>customers;
    private List<Product> products;
    private Set<User>users;

    private Sales() {
    }

    private Sales(Builder builder){
        this.salesId = builder.salesId;
        this.salesTotal = builder.salesTotal;
    }

    public String getSalesId() {
        return salesId;
    }

    public double getSalesTotal() {
        return salesTotal;
    }

    public static class Builder{
        private String salesId;
        private double salesTotal;
        private Set<Customer>customers;
        private List<Product> products;
        private Set<User>users;

        public Builder salesId(String salesId) {
            this.salesId = salesId;
            return this;
        }

        public Builder salesTotal(double salesTotal) {
            this.salesTotal = salesTotal;
            return this;
        }

        public Builder Copy(Sales sales){
            this.salesId = sales.salesId;
            this.salesTotal = sales.salesTotal;

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
