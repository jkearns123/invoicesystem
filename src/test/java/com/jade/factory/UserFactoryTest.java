package com.jade.factory;

import com.jade.domain.Contact;
import com.jade.domain.Email;
import com.jade.domain.Name;
import com.jade.domain.User;
import com.jade.util.Miscellaneous;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserFactoryTest {

    String firstName = "Jade";
    String lastName = "Kearns";
    String contactNumber = "0713078199";
    String emailAdd = "jkearns123@gmail.com";

    User user = UserFactory.getUser();

    Name userName = NameFactory.getName(firstName,lastName);
    Contact userContacts = ContactFactory.getContact(contactNumber,contactNumber,contactNumber);
    Email userEmails = EmailFactory.getEmail(emailAdd);

    @Test
    public void getUserTestFirstName() {

        Assert.assertEquals("Jade", userName.getFirstName());

    }

    @Test
    public void getUserTestLastName() {

        Assert.assertEquals("Kearns", userName.getLastName());

    }

    @Test
    public void getUserTestContactNumber() {

        Assert.assertEquals("0713078199", userContacts.getWorkContact());

    }

    @Test
    public void getEmail() {
        Assert.assertEquals("jkearns123@gmail.com",userEmails.getEmailAddress());
    }

    @Test
    public void getUserTestID() {

        assertNotNull(user.getUserId());

    }
}