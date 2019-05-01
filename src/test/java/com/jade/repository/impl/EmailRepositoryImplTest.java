package com.jade.repository.impl;

import com.jade.domain.Email;
import com.jade.factory.EmailFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder
        (MethodSorters.NAME_ASCENDING)
public class EmailRepositoryImplTest {

    private EmailRepositoryImpl repository;
    private Email email;

    private Email getTestEmail(){
        String testEmail = "jkearns123@gmail.com";

        return EmailFactory.getEmail(testEmail);
    }

    private Email getSavedEmail(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = (EmailRepositoryImpl) EmailRepositoryImpl.getRepository();
        this.email = getTestEmail();

        Email savedEmail = this.repository.create(this.email);

    }

    @Test
    public void aNotNullCheck(){
        Assert.assertNotNull(email);
    }

    @Test
    public void bEmailCheck() {
        Assert.assertEquals("jkearns123@gmail.com",email.getEmailAddress());
    }

}