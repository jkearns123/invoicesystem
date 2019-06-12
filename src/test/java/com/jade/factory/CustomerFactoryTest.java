package com.jade.factory;

import com.jade.domain.*;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerFactoryTest {
    String firstName = "Atlas";
    String lastName = "Mulligan";
    String cellContact = "0219039881";
    String workContact = "0214661513";
    String homeContact = "0713074569";
    String emailAdd = "AtlMulligan@gmail.com";
    String street = "37 Chelmsford";
    String city = "Cape Town";
    String region = "Western Cape";
    String postalCode = "8001";


    Name customerName = NameFactory.getName(firstName,lastName);
    Address customerAddresss = AddressFactory.getAddress(street,city,region,postalCode);
    Contact customerContacts = ContactFactory.getContact(cellContact,workContact,homeContact);
    Email customerEmails = EmailFactory.getEmail(emailAdd);
    Customer customer = CustomerFactory.getCustomer(customerName,customerAddresss,customerContacts,customerEmails);



    @Test
    public void getCustomerTestFirstName() {

        Assert.assertEquals("Atlas",customerName.getFirstName());
    }

    @Test
    public void getCustomerTestLastName() {

        Assert.assertEquals("Mulligan",customerName.getLastName());
    }

    @Test
    public void getCustomerTestAddress() {

        Assert.assertEquals("37 Chelmsford",customerAddresss.getStreet());

    }

    @Test
    public void getCustomerTestContact() {

        Assert.assertEquals("0214661513",customerContacts.getWorkContact());
    }

    @Test
    public void getCustomerTestEmail() {

        Assert.assertEquals("AtlMulligan@gmail.com",customerEmails.getEmailAddress());
    }

    @Test
    public void getCustomerTestID(){
        assertNotNull(customer.getCustomerId());
    }
}