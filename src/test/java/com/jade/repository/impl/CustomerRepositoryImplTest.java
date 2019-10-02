//package com.jade.repository.impl;
//
//import com.jade.domain.*;
//import com.jade.factory.*;
//import com.jade.repository.CustomerRepository;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.FixMethodOrder;
//import org.junit.*;
//import org.junit.runners.MethodSorters;
//
//import java.util.Set;
//
//import static org.junit.Assert.*;
//
////The FixMethodOrder class allows the user to choose the order of execution of the methods within a test class
//@FixMethodOrder
//        (MethodSorters.NAME_ASCENDING)
//public class CustomerRepositoryImplTest {
//
//    private CustomerRepositoryImpl repository;
//    private Customer customer;
//    //private Name name;
//
//
//    //private CustomerRepository repository;
//
//    String testFirstName = "Jade";
//    String testLastName = "Kearns";
//    String testStreet = "37 Chelmsford";
//    String testCity = "Cape Town";
//    String testRegion = "Western Cape";
//    String testPostalCode = "8001";
//    String testCellContact = "0713078199";
//    String testWorkContact = "0214661513";
//    String testHomeContact = "0214613586";
//    String testEmailAddress = "jkearns123@gmail.com";
//
//    private Customer getTestCustomer(){
//
//        Name name = NameFactory.getName(testFirstName,testLastName);
//        Address address = AddressFactory.getAddress(testStreet,testCity,testRegion,testPostalCode);
//        Contact contact = ContactFactory.getContact(testCellContact,testWorkContact,testHomeContact);
//        Email email = EmailFactory.getEmail(testEmailAddress);
//
//        return CustomerFactory.getCustomer(name,address,contact,email);
//    }
//
//    private Customer getSavedCustomer(){
//        return this.repository.getAll().iterator().next();
//    }
//
//    @Before
//    public void setUp() throws Exception{
//        //Incompatible types cast to RepositoryImpl
//        this.repository = (CustomerRepositoryImpl) CustomerRepositoryImpl.getRepository();
//        this.customer = getTestCustomer();
//    }
//
//
//    @Test
//    public void aCreate() {
//        Customer savedCustomer = this.repository.create(this.customer);
//
//        System.out.println("Created record:\n**************");
//        System.out.println(savedCustomer);
//        Assert.assertNotNull(savedCustomer);
//
//    }
//
//
//    @Test
//    public void bRead() {
//        Customer testCustomer = getSavedCustomer();
//        Customer readCustomer = this.repository.read(testCustomer.getCustomerId());
//
//        System.out.println("Read record:\n**************");
//
//        System.out.println("Saved Record: " + testCustomer);
//        System.out.println("Read Record: " + readCustomer);
//
//        Assert.assertSame(testCustomer,readCustomer);
//    }
//
//    @Test
//    public void cUpdate() {
//        String updateLastName = "Mulligan";
//        String updateStreet = "37 Chelmsford";
//        String updateEmail = "swincInfo@gmail.com";
//        String updateWorkContact = "0119039881";
//
//        Name updateCustomerName = NameFactory.getName(testFirstName,updateLastName);
//        Address updateCustomerAddresss = AddressFactory.getAddress(updateStreet,testCity,testRegion,testPostalCode);
//        Contact updateCustomerContacts = ContactFactory.getContact(testCellContact,testWorkContact,updateWorkContact);
//        Email updateCustomerEmails = EmailFactory.getEmail(updateEmail);
//
//        Customer customer = getSavedCustomer();
//        Customer copyOfCustomer = new Customer.Builder().Copy(customer).name(updateCustomerName).address(updateCustomerAddresss).contact(updateCustomerContacts).email(updateCustomerEmails).build();
//        Customer updatedCustomer = this.repository.update(copyOfCustomer);
//
//        System.out.println("Update record:\n**************");
//
//        System.out.println("Previous Record: " + customer);
//        System.out.println("Updated Record: " + updatedCustomer);
//
//        System.out.println("The array is: " + this.repository.getAll());
//        Assert.assertNotNull(updatedCustomer);
//        Assert.assertNotEquals(customer.getAddress(),updatedCustomer.getAddress());
//        Assert.assertNotEquals(customer.getName(),updatedCustomer.getName());
//        Assert.assertNotEquals(customer.getEmail(),updatedCustomer.getEmail());
//        Assert.assertNotEquals(customer.getContact(),updatedCustomer.getContact());
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
//        Customer customer = getSavedCustomer();
//        this.repository.delete(customer.getCustomerId());
//        System.out.println("Delete record:\n**************");
//
//        System.out.println("Current record: " + customer);
//        System.out.println("Deleted: " + this.repository.getAll());
//
//        Assert.assertEquals(0,this.repository.getAll().size());
//    }
//}