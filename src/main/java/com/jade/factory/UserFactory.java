package com.jade.factory;

import com.jade.domain.User;
import com.jade.util.Miscellaneous;

public class UserFactory {
    public static User getUser() {
        return new User.Builder()
                .userId(Miscellaneous.generateRandomId())
                .build();
    }
}
