package com.jade.domain;

import java.util.Objects;

public class Address {
    //added addressId
    String addressId, street, city, region, postalCode;

    private Address() {
    }


    private Address(Builder builder){
        //added addressId
        this.addressId = builder.addressId;
        this.street = builder.street;
        this.city = builder.city;
        this.region = builder.region;
        this.postalCode = builder.postalCode;

    }

    //added getter for addressId
    public String getAddressId() {
        return addressId;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public static class Builder{
        //added addressId
        String addressId, street, city, region, postalCode;

        //added builder addressId to parse to getter
        public Builder addressId(String addressId){
            this.addressId = addressId;
            return this;
        }

        public Builder street(String street) {
            this.street = street;
            return this;
        }


        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder region(String region) {
            this.region = region;
            return this;
        }

        //added copy of builder
        public Builder copy(Address address){
            this.addressId = address.addressId;
            this.street = address.street;
            this.city = address.city;
            this.region = address.region;
            this.postalCode = address.postalCode;

            return this;
        }

        public Address build(){
            return new Address(this);
        }
    }

    //changed toString - regenerated toString to include addressId
    @Override
    public String toString() {
        return "Address{" +
                "addressId='" + addressId + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }

    //added equals() and hashcode() select only id and tick last two
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        return addressId.equals(address.addressId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId);
    }
}
