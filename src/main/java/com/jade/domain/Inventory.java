package com.jade.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="inventory_id")
    private String inventoryId;
    private String productDescription;
    private double productPrice;

    private Inventory(){

    }

    private Inventory(Builder builder){
        this.inventoryId = builder.inventoryId;
        this.productDescription = builder.productDescription;
        this.productPrice = builder.productPrice;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }


    public static class Builder{
        private String inventoryId, productDescription;
        private double productPrice;

        public Builder inventoryId(String inventoryId){
            this.inventoryId = inventoryId;
            return this;
        }

        public Builder productDescription(String productDescription) {
            this.productDescription = productDescription;
            return this;
        }

        public Builder productPrice(double productPrice) {
            this.productPrice = productPrice;
            return this;
        }

        public Builder copy(Inventory inventory){
            this.inventoryId = inventory.inventoryId;
            this.productDescription = inventory.productDescription;
            this.productPrice = inventory.productPrice;

            return this;
        }

        public Inventory build(){return new Inventory(this);}

    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryId='" + inventoryId + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inventory inventory = (Inventory) o;

        return inventoryId.equals(inventory.inventoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventoryId);
    }
}
