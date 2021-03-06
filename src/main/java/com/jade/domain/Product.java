package com.jade.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "product")
public class Product{

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="product_id")
    private String productId;
    private String productName;
    private int productQuantity;
    private double price;

    private Product() {
    }

    private Product(Builder builder){
        this.productId = builder.productId;
        this.productName = builder.productName;
        this.productQuantity = builder.productQuantity;
        this.price = builder.price;

    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public double getPrice() {
        return price;
    }


    public static class Builder{
        private String productId, productName;
        private int productQuantity;
        private double price;

        public Builder productId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder productQuantity(int productQuantity) {
            this.productQuantity = productQuantity;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder Copy(Product product){
            this.productId = product.productId;
            this.productName = product.productName;
            this.productQuantity = product.productQuantity;
            this.price = product.price;

            return this;
        }

        public Product build(){return new Product(this);}
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productQuantity=" + productQuantity +
                ", price=" + price +
                '}';
    }
//identify Id as Unique each objects

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return productId.equals(product.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}
