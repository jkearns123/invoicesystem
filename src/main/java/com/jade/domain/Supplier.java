package com.jade.domain;

import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

@Entity(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name="supplier_id")
    private String supplierId;
    private String supplierName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Product> products;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact", referencedColumnName = "contact_id")
    private Contact contact;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address", referencedColumnName = "address_id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "email", referencedColumnName = "email_id")
    private Email email;

    private Supplier() {
    }

    private Supplier(Builder builder) {
        this.supplierId = builder.supplierId;
        this.supplierName = builder.supplierName;
        this.contact = builder.contact;
        this.address = builder.address;
        this.email = builder.email;
        this.products = builder.products;
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

    public List<Product> getProducts(){return products;}

    public static class Builder {
        private String supplierId, supplierName;
        private List<Product> products;
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

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public Builder contact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Builder email(Email email) {
            this.email = email;
            return this;
        }

        public Builder products(Product product){
            this.products = (List<Product>) product;
            return this;
        }

        public Builder Copy(Supplier supplier) {
            this.supplierId = supplier.supplierId;
            this.supplierName = supplier.supplierName;
            this.contact = supplier.contact;
            this.address = supplier.address;
            this.email = supplier.email;
            this.products = supplier.products;

            return this;
        }

        public Supplier build() {
            return new Supplier(this);
        }
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId='" + supplierId + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ", products=" + products +
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
        return Objects.hash(supplierId);
    }
}
