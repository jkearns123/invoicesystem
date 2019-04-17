package com.jade.factory;

import com.jade.domain.Contact;

public class ContactFactory {

    public static Contact getContact(String cellContact, String workContact, String homeContact) {
        return new Contact.Builder().cellContact(cellContact)
                .workContact(workContact)
                .homeContact(homeContact).build();
    }
}