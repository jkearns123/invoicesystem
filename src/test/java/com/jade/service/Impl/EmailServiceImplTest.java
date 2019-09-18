package com.jade.service.Impl;

import com.jade.domain.*;
import com.jade.factory.EmailFactory;
import com.jade.repository.impl.EmailRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;
@FixMethodOrder
        (MethodSorters.NAME_ASCENDING)
public class EmailServiceImplTest {

    private EmailRepositoryImpl repository;
    private Email email;

    String emailAddress = "jadek@heliosits.co.za";

    private Email getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = EmailRepositoryImpl.getRepository();
        this.email = EmailFactory.getEmail(emailAddress);
    }

    @Test
    public void dGetAll() {
        Set<Email>emails = this.repository.getAll();
        System.out.println("In getall, all; " + emails);

        Assert.assertEquals(1,this.repository.getAll().size());
    }

    @Test
    public void aCreate() {
        Email createEmail = this.repository.create(this.email);
        System.out.println("In create, created: " + createEmail);

        Assert.assertNotNull(createEmail);
        Assert.assertSame(createEmail,this.email);
    }

    @Test
    public void cUpdate() {
        String newEmailAddress = "jadek@afrocentrictechnologies.co.za";
        Email updated = new Email.Builder().copy(getSaved()).emailAddress(newEmailAddress).build();
        System.out.println("In update, updated: " + updated);
        this.repository.update(updated);

        Assert.assertSame(newEmailAddress,updated.getEmailAddress());
        System.out.println("Array includes: " + this.repository.getAll());
    }

    @Test
    public void bRead() {
        Email savedEmail = getSaved();
        Email read = this.repository.read(savedEmail.getEmailId());
        System.out.println("In read, read: " + read);

        Assert.assertSame(read,savedEmail);
    }

    @Test
    public void eDelete() {
        Email saved = getSaved();
        this.repository.delete(saved.getEmailId());

        System.out.println("In array after delete: " + repository.getAll());

        Assert.assertEquals(0,this.repository.getAll().size());
    }
}