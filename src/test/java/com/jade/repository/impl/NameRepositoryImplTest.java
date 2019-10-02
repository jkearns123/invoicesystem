//package com.jade.repository.impl;
//
//import com.jade.domain.Name;
//import com.jade.factory.NameFactory;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//
//import static org.junit.Assert.*;
//
//@FixMethodOrder
//        (MethodSorters.NAME_ASCENDING)
//public class NameRepositoryImplTest {
//
//    private NameRepositoryImpl repository;
//    private Name name;
//
//    private Name getTestName(){
//        String testFirstName = "Jade";
//        String testLastName = "Kearns";
//
//        return NameFactory.getName(testFirstName,testLastName);
//    }
//
//    private Name getSavedName(){
//        return this.repository.getAll().iterator().next();
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        this.repository = (NameRepositoryImpl) NameRepositoryImpl.getRepository();
//        this.name = getTestName();
//
//        Name savedName = this.repository.create(this.name);
//    }
//
//    @Test
//    public void aNotNullCheck() {
//        Assert.assertNotNull(name);
//    }
//
//    @Test
//    public void bCheckCellContact() {
//        Assert.assertEquals("Jade",name.getFirstName());
//    }
//
//    @Test
//    public void cCheckWorkContact() {
//        Assert.assertEquals("Kearns",name.getLastName());
//    }
//}