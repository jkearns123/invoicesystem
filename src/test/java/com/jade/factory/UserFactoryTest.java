package com.jade.factory;

import com.jade.domain.User;
import com.jade.util.Miscellaneous;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserFactoryTest {

    String userFirstName = "Jade";
    String userLastName = "Kearns";
    String contactNumber = "0713078199";

    User user = UserFactory.getUser(userFirstName, userLastName, contactNumber);

    @Test
    public void getUserTestFirstName() {

        Assert.assertEquals("Jade", user.getUserFirstName());

    }

    @Test
    public void getUserTestLastName() {

        Assert.assertEquals("Kearns", user.getUserLastName());

    }

    @Test
    public void getUserTestContactNumber() {

        Assert.assertEquals("0713078199", user.getContactNumber());

    }

    @Test
    public void getUserTestID() {

        assertNotNull(user.getUserId());

    }
}