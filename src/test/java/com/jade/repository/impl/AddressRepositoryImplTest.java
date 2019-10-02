//package com.jade.repository.impl;
//
//import com.jade.domain.Address;
//import com.jade.factory.AddressFactory;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//
//
//import static org.junit.Assert.*;
//
//@FixMethodOrder
//        (MethodSorters.NAME_ASCENDING)
//public class AddressRepositoryImplTest {
//
//    private AddressRepositoryImpl repository;
//    private Address address;
//
//    private Address getTestAddress(){
//        String testStreetAddress = "2 Bloomfield Court";
//        String testCityAddress = "Cape Town";
//        String testRegionAddress = "Western Cape";
//        String testPostalAddress = "8001";
//
//        return AddressFactory.getAddress(testStreetAddress,testCityAddress,testRegionAddress,testPostalAddress);
//    }
//
//    private Address getSavedAddress(){
//        return this.repository.getAll().iterator().next();
//    }
//
//    @Before
//    public void setUp() throws Exception {
//
//        this.repository = (AddressRepositoryImpl) AddressRepositoryImpl.getRepository();
//        this.address = getTestAddress();
//
//        Address savedAddress = this.repository.create(this.address);
//    }
//
//    @Test
//    public void aNotNullCheck() {
//        Assert.assertNotNull(address);
//    }
//
//
//    @Test
//    public void bCheckStreetAddress() {
//        Assert.assertEquals("2 Bloomfield Court", address.getStreet());
//    }
//
//    @Test
//    public void cCheckCityAddress() {
//        Assert.assertEquals("Cape Town", address.getCity());
//    }
//
//    @Test
//    public void dCheckRegionAddress() {
//        Assert.assertEquals("Western Cape",address.getRegion());
//        }
//
//    @Test
//    public void dCheckPostalAddress() {
//        Assert.assertEquals("8001",address.getPostalCode());
//    }
//}