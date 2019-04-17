package com.jade.factory;

import com.jade.domain.Address;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressFactoryTest {

    String street = "37 Chelmsford";
    String city = "Cape Town";
    String region = "Western Cape";
    String postalCode = "8001";

    Address addresss = AddressFactory.getAddress(street,city,region,postalCode);

    @Test
    public void getAddress() {
        Assert.assertEquals("37 Chelmsford",addresss.getCity());
    }
}