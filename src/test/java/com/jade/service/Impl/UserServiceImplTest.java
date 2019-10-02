//package com.jade.service.Impl;
//
//import com.jade.domain.*;
//import com.jade.factory.ContactFactory;
//import com.jade.factory.EmailFactory;
//import com.jade.factory.NameFactory;
//import com.jade.factory.UserFactory;
//import com.jade.repository.impl.NameRepositoryImpl;
//import com.jade.repository.impl.UserRepositoryImpl;
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
//public class UserServiceImplTest {
//
//    private UserRepositoryImpl repository;
//    private User user;
//
//    String firstName = "Swae";
//    String lastName = "Lee";
//    String cellContact = "0713078156";
//    String workContact = "0214665533";
//    String homeContact = "0219039881";
//    String emailAddress = "jadek@heliosits.co.za";
//
//    Name name = NameFactory.getName(firstName,lastName);
//    Contact contact = ContactFactory.getContact(cellContact,workContact,homeContact);
//    Email email = EmailFactory.getEmail(emailAddress);
//
//    private User getSaved(){
//        return this.repository.getAll().iterator().next();
//    }
//
//
//
//    @Before
//    public void setUp() throws Exception {
//
//        this.repository = UserRepositoryImpl.getRepository();
//        this.user = UserFactory.getUser(name,contact,email);
//    }
//
//    @Test
//    public void dGetAll() {
//        Set<User> users = this.repository.getAll();
//        System.out.println("In getall, all: " + users);
//
//        Assert.assertEquals(1,this.repository.getAll().size());
//    }
//
//    @Test
//    public void aCreate() {
//        User createUser = this.repository.create(this.user);
//        System.out.println("In create, created: " + createUser);
//
//        Assert.assertNotNull(createUser);
//
//        Assert.assertSame(createUser, this.user);
//    }
//
//    @Test
//    public void cUpdate() {
//        String newEmailAddress = "jadek@afrocentrictechnologies.co.za";
//        Email newUserEmailAddress = EmailFactory.getEmail(newEmailAddress);
//
//        User updated = new User.Builder().Copy(getSaved()).email(newUserEmailAddress).build();
//        System.out.println("In update, updated: " + updated);
//        this.repository.update(updated);
//
//        Assert.assertSame(newUserEmailAddress,updated.getEmail());
//    }
//
//    @Test
//    public void bRead() {
//        User savedUser = getSaved();
//        User read = this.repository.read(savedUser.getUserId());
//        System.out.println("In read, read = " + read);
//
//        Assert.assertSame(read,savedUser);
//    }
//
//    @Test
//    public void eDelete() {
//        User saved = getSaved();
//        this.repository.delete(saved.getUserId());
//
//        System.out.println("In array after delete: " + repository.getAll());
//
//        Assert.assertEquals(0,this.repository.getAll().size());
//    }
//}