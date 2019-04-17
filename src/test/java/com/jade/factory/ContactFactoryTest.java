package com.jade.factory;

import com.jade.domain.Contact;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactFactoryTest {


    String contactNumber = "0713078199";
    String contactNumber2 = "0214661513";
    String contactNumber3 = "0219039881";

    Contact contacts = ContactFactory.getContact(contactNumber,contactNumber2,contactNumber3);

    @Test
    public void getContact1() {
        Assert.assertEquals("0713078199", contacts.getCellContact());
    }

    @Test
    public void getContact2() {
        Assert.assertEquals("0214661513", contacts.getWorkContact());
    }

    @Test
    public void getContact3() {
        Assert.assertEquals("0219039881", contacts.getHomeContact());
    }
}