package com.jade.domain;

public class Address {
    String street, city, region, postalCode;

    private Address() {
    }


    private Address(Builder builder){
        this.street = builder.street;
        this.city = builder.city;
        this.region = builder.region;
        this.postalCode = builder.postalCode;

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
        String street, city, region, postalCode;

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

        public Address build(){return new Address(this);}
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }
}
