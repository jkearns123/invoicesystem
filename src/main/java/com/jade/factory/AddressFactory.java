package com.jade.factory;

import com.jade.domain.Address;
import com.jade.util.Miscellaneous;

public class AddressFactory {
    public static Address getAddress(String street, String city, String region, String postalCode){
        //added .addressId(Miscellaneous.generateRandomId()) to builder
        return new Address.Builder().addressId(Miscellaneous.generateRandomId()).street(street)
                .city(city)
                .region(region)
                .postalCode(postalCode).build();

    }
}
