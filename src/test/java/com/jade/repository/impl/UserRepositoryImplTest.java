//package com.jade.repository.impl;
//
//import com.jade.domain.*;
//import com.jade.factory.*;
//import org.junit.*;
//import org.junit.runners.MethodSorters;
//
//import static org.junit.Assert.*;
//
////The FixMethodOrder class allows the user to choose the order of execution of the methods within a test class
//@FixMethodOrder
//        (MethodSorters.NAME_ASCENDING)
//public class UserRepositoryImplTest {
//
//    private UserRepositoryImpl repository;
//    private User user;
//
//    String firstName = "Jade";
//    String lastName = "Kearns";
//    String contactNumber = "0713078199";
//    String workContact = "0214658599";
//    String homeContact = "0114562323";
//    String emailAdd = "jkearns123@gmail.com";
//
//    private User getTestUser(){
//
//        Name name = NameFactory.getName(firstName,lastName);
//        Contact contact = ContactFactory.getContact(contactNumber,workContact,homeContact);
//        Email email = EmailFactory.getEmail(emailAdd);
//
//        return UserFactory.getUser(name,contact,email);
//
//    }
//
//    private User getSavedUser(){
//        return this.repository.getAll().iterator().next();
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        //Incompatible types cast to RepositoryImpl
//        this.repository = (UserRepositoryImpl) UserRepositoryImpl.getRepository();
//        this.user = getTestUser();
//    }
//
//    @Test
//    public void aCreate() {
//        User savedUser = this.repository.create(this.user);
//        System.out.println("Created record:\n**************");
//        System.out.println(savedUser);
//        Assert.assertNotNull(savedUser);
//    }
//
//
//    @Test
//    public void bRead() {
//        User testUser = getSavedUser();
//        User readUser = this.repository.read(testUser.getUserId());
//        System.out.println("Read record:\n**************");
//        System.out.println("Saved Record: " + testUser);
//        System.out.println("Read Record: " + readUser);
//
//        Assert.assertSame(testUser,readUser);
//    }
//
//    @Test
//    public void cUpdate() {
//        String updateEmail = "emailchanged@changeisgood.com";
//
//        Email updateUserEmail = EmailFactory.getEmail(updateEmail);
//
//        User user = getSavedUser();
//        User copyOfUser = new User.Builder().Copy(user).email(updateUserEmail).build();
//        User updatedUser = this.repository.update(copyOfUser);
//
//        System.out.println("Update record:\n**************");
//        System.out.println("Previous Record: " + user);
//        System.out.println("Updated Record: " + updatedUser);
//
//        Assert.assertNotNull(updatedUser);
//        Assert.assertNotEquals(user.getEmail(),updatedUser.getEmail());
//        Assert.assertEquals(user.getName(),updatedUser.getName());
//    }
//
//    @Test
//    public void dGetAll() {
//        System.out.println("Get all records:\n**************");
//        System.out.println(this.repository.getAll());
//        Assert.assertNotNull(this.repository.getAll());
//    }
//
//    @Test
//    public void eDelete() {
//        User user = getSavedUser();
//        this.repository.delete(user.getUserId());
//
//        System.out.println("Delete record:\n**************");
//        System.out.println("Current record: " + user);
//        System.out.println("Deleted: " + this.repository.getAll());
//        Assert.assertEquals(0,this.repository.getAll().size());
//    }
//}