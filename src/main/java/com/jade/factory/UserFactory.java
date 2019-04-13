package com.jade.factory;

import com.jade.domain.User;
import com.jade.util.Miscellaneous;

public class UserFactory {
    public static User getUser(String userFirstName, String userLastName, String contactNumber) {
        return new User.Builder().contactNumber(contactNumber)
                .userFirstName(userFirstName)
                .userLastName(userLastName)
                .userId(Miscellaneous.generateRandomId())
                .build();
    }
}
