package com.jade.repository.impl;

import com.jade.domain.Contact;
import com.jade.factory.ContactFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import static org.junit.Assert.*;

@FixMethodOrder
        (MethodSorters.NAME_ASCENDING)
public class ContactRepositoryImplTest {

    private ContactRepositoryImpl repository;
    private Contact contact;

    private Contact getTestContact(){
        String testCellContact = "0713078199";
        String testWorkContact = "0214661513";
        String testHomeContact = "0219039881";

        return ContactFactory.getContact(testCellContact,testWorkContact,testHomeContact);
    }

    private Contact getSavedContact(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {

        this.repository = (ContactRepositoryImpl) ContactRepositoryImpl.getRepository();
        this.contact = getTestContact();

        Contact savedContact = this.repository.create(this.contact);
    }

    @Test
    public void aNotNullCheck() {
        Assert.assertNotNull(contact);
    }

    @Test
    public void bCheckCellContact() {
        Assert.assertEquals("0713078199",contact.getCellContact());
    }

    @Test
    public void cCheckWorkContact() {
        Assert.assertEquals("0214661513",contact.getWorkContact());
    }

    @Test
    public void dCheckHomeContact() {
        Assert.assertEquals("0219039881",contact.getHomeContact());
    }

}