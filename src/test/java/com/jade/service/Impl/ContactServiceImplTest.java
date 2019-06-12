package com.jade.service.Impl;

import com.jade.domain.Contact;
import com.jade.factory.ContactFactory;
import com.jade.repository.impl.ContactRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder
        (MethodSorters.NAME_ASCENDING)
public class ContactServiceImplTest {

    private ContactRepositoryImpl repository;
    private Contact contact;

    String cellContact = "0713078156";
    String workContact = "0214665533";
    String homeContact = "0219039881";

    private Contact getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ContactRepositoryImpl.getRepository();
        this.contact = ContactFactory.getContact(cellContact,workContact,homeContact);
    }

    @Test
    public void dGetAll() {
        Set<Contact>contacts = this.repository.getAll();
        System.out.println("In getall, all:" + contacts);

        Assert.assertEquals(1, this.repository.getAll().size());
    }

    @Test
    public void aCreate() {
        Contact createContact = this.repository.create(this.contact);
        System.out.println("In create, created: " + createContact);

        Assert.assertNotNull(createContact);

        Assert.assertSame(createContact, this.contact);
    }

    @Test
    public void cUpdate() {
        String newWorkNumber = "0214661513";
        Contact updated = new Contact.Builder().copy(getSaved()).workContact(newWorkNumber).build();
        System.out.println("In update, updated: " + updated);
        this.repository.update(updated);

        Assert.assertSame(newWorkNumber,updated.getWorkContact());
    }

    @Test
    public void bRead() {
        Contact savedContact = getSaved();
        Contact read = this.repository.read(savedContact.getContactId());
        System.out.println("In read, read: " + read);

        Assert.assertSame(read,savedContact);
    }

    @Test
    public void eDelete() {
        Contact saved = getSaved();
        this.repository.delete(saved.getContactId());

        System.out.println("In array after delete: " + repository.getAll());

        Assert.assertEquals(0,this.repository.getAll().size());
    }
}