package com.jade.factory;

import com.jade.domain.Name;
import com.jade.util.Miscellaneous;

public class NameFactory {
    public static Name getName(String firstName, String lastName) {
        return new Name.Builder().nameId(Miscellaneous.generateRandomId()).firstName(firstName)
                .lastName(lastName).build();
    }
}
