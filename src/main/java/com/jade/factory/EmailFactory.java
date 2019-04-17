package com.jade.factory;

import com.jade.domain.Email;

public class EmailFactory {
    public static Email getEmail(String emailAddress) {
        return new Email.Builder().emailAddress(emailAddress).build();
    }
}
