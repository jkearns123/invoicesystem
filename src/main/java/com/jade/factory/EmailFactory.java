package com.jade.factory;

import com.jade.domain.Email;
import com.jade.util.Miscellaneous;

public class EmailFactory {
    public static Email getEmail(String emailAddress) {
        return new Email.Builder().emailId(Miscellaneous.generateRandomId()).emailAddress(emailAddress).build();
    }
}
