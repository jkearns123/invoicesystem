//package com.jade.factory;
//
//import com.jade.domain.Address;
//import com.jade.domain.Contact;
//import com.jade.domain.Email;
//import com.jade.domain.Supplier;
//import org.junit.Assert;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class SupplierFactoryTest {
//
//    String supplierName = "Unilever";
//    String supplierContact = "0860572908";
//    String supplierWorkContact = "0213078199";
//    String street = "100 Victoria";
//    String city = "Victoria Embankment";
//    String region = "London";
//    String postalCode = "1001";
//    String supplierEmail = "consumer.affairs-za@unilever.com";
//
//    Contact contact = ContactFactory.getContact(supplierContact,supplierWorkContact,"");
//    Address address = AddressFactory.getAddress(street,city,region,postalCode);
//    Email email = EmailFactory.getEmail(supplierEmail);
//
//    Supplier supplier = SupplierFactory.getSupplier(supplierName,contact,address,email);
//
//    Address supplierAddresss = AddressFactory.getAddress(street,city,region,postalCode);
//    Contact supplierContacts = ContactFactory.getContact(supplierContact,supplierContact,supplierContact);
//    Email supplierEmails = EmailFactory.getEmail(supplierEmail);
//
//    @Test
//    public void getSupplierTestName() {
//
//        Assert.assertEquals("Unilever",supplier.getSupplierName());
//    }
//
//    @Test
//    public void getSupplierTestContact() {
//
//        Assert.assertEquals("0860572908",supplierContacts.getWorkContact());
//    }
//
//    @Test
//    public void getSupplierTestAddress() {
//
//        Assert.assertEquals("London",supplierAddresss.getRegion());
//    }
//
//    @Test
//    public void getSupplierTestEmail() {
//
//        Assert.assertEquals("consumer.affairs-za@unilever.com",supplierEmails.getEmailAddress());
//    }
//
//    @Test
//    public void getSupplierTestID() {
//
//        assertNotNull(supplier.getSupplierId());
//    }
//}