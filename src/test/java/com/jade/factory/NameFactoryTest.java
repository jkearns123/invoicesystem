package com.jade.factory;

import com.jade.domain.Name;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class NameFactoryTest {

    String firstName = "Jade";
    String lastName = "Kearns";

    Name name = NameFactory.getName(firstName,lastName);

    @Test
    public void getFirstName() {

        Assert.assertEquals("Jade", name.getFirstName());

    }

    @Test
    public void getLastName() {

        Assert.assertEquals("Kearns", name.getLastName());

    }
}