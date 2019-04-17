package com.jade.factory;

import com.jade.domain.Name;

public class NameFactory {
    public static Name getName(String firstName, String lastName) {
        return new Name.Builder().firstName(firstName)
                .lastName(lastName).build();
    }
}
