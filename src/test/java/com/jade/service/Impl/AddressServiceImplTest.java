//package com.jade.service.Impl;
//
//import com.jade.domain.*;
//
//import com.jade.factory.AddressFactory;
//import com.jade.repository.impl.AddressRepositoryImpl;
//import com.jade.service.AddressService;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//
//import java.util.Set;
//
//import static org.junit.Assert.*;
//
//@FixMethodOrder
//        (MethodSorters.NAME_ASCENDING)
//public class AddressServiceImplTest {
//
//    private AddressRepositoryImpl repository;
//    private Address address;
//
//
//    String street = "Inglewood";
//    String city = "California";
//    String region = "United States";
//    String postalCode = "90302";
//
//    private Address getSaved(){
//        return this.repository.getAll().iterator().next();
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        this.repository = AddressRepositoryImpl.getRepository();
//        this.address = AddressFactory.getAddress(street,city,region,postalCode);
//
//    }
//
//    @Test
//    public void dGetAll() {
//        Set<Address>addresses = this.repository.getAll();
//        System.out.println("In getall, all: " + addresses);
//
//        Assert.assertEquals(1,this.repository.getAll().size());
//    }
//
//    @Test
//    public void aCreate() {
//        Address createAddress = this.repository.create(this.address);
//        System.out.println("In create, created: " + createAddress);
//
//        Assert.assertNotNull(createAddress);
//
//        Assert.assertSame(createAddress, this.address);
//    }
//
//    @Test
//    public void cUpdate() {
//        String newStreetName = "Trap Street";
//        Address updated = new Address.Builder().copy(getSaved()).street(newStreetName).build();
//        System.out.println("In update, updated: " + updated);
//        this.repository.update(updated);
//
//        Assert.assertSame(newStreetName,updated.getStreet());
//    }
//
//    @Test
//    public void bRead() {
//        Address savedAddress = getSaved();
//        Address read = this.repository.read(savedAddress.getAddressId());
//        System.out.println("In read, read = " + read);
//
//        Assert.assertSame(read,savedAddress);
//    }
//
//    @Test
//    public void eDelete() {
//        Address saved = getSaved();
//        this.repository.delete(saved.getAddressId());
//
//        System.out.println("In array after delete: " + repository.getAll());
//
//        Assert.assertEquals(0,this.repository.getAll().size());
//    }
//}