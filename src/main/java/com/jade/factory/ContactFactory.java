package com.jade.factory;

import com.jade.domain.Contact;
import com.jade.util.Miscellaneous;

public class ContactFactory {

    public static Contact getContact(String cellContact, String workContact, String homeContact) {
        return new Contact.Builder().contactId(Miscellaneous.generateRandomId()).cellContact(cellContact)
                .workContact(workContact)
                .homeContact(homeContact).build();
    }
}