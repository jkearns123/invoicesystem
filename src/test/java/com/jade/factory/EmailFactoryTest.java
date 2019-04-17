package com.jade.factory;

import com.jade.domain.Email;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmailFactoryTest {

    String emailAdd = "jkearns123@gmail.com";

    Email emails = EmailFactory.getEmail(emailAdd);

    @Test
    public void getEmail() {
        Assert.assertEquals("jkearns123@gmail.com",emails.getEmailAddress());
    }
}