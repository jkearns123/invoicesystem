//package com.jade.service.Impl;
//
//import com.jade.domain.*;
//import com.jade.factory.*;
//import com.jade.factory.CustomerFactory;
//import com.jade.repository.CustomerRepository;
//import com.jade.repository.impl.CustomerRepositoryImpl;
//import com.jade.service.CustomerService;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//
//import java.util.Set;
//
//import static org.junit.Assert.*;
//@FixMethodOrder
//        (MethodSorters.NAME_ASCENDING)
//public class CustomerServiceImplTest {
//
//    private CustomerRepositoryImpl repository;
//    private Customer customer;
//
//    String firstName = "Jade";
//    String lastName = "Kearns";
//    String cellContact = "0713078199";
//    String workContact = "0214665533";
//    String homeContact = "0214613425";
//    String emailAdd = "jadek@gmail.com";
//    String street = "Excelsior street";
//    String city = "Kuils River";
//    String region = "Western Cape";
//    String postalCode = "7580";
//
//    Name customerName = NameFactory.getName(firstName,lastName);
//    Address customerAddress = AddressFactory.getAddress(street,city,region,postalCode);
//    Contact customerContacts = ContactFactory.getContact(cellContact,workContact,homeContact);
//    Email customerEmail = EmailFactory.getEmail(emailAdd);
//
//    private Customer getSaved(){
//        return this.repository.getAll().iterator().next();
//    }
//
//
//    @Before
//    public void setUp() throws Exception {
//
//        this.repository = CustomerRepositoryImpl.getRepository();
//        this.customer = CustomerFactory.getCustomer(customerName,customerAddress,customerContacts,customerEmail);
//    }
//
//    @Test
//    public void dGetAll() {
//        Set<Customer> customers = this.repository.getAll();
//        System.out.println("In getall, all: " + customers);
//
//        Assert.assertEquals(1,this.repository.getAll().size());
//    }
//
//    @Test
//    public void aCreate() {
//        Customer createCustomer = this.repository.create(this.customer);
//        System.out.println("In create, created: " + createCustomer);
//
//        Assert.assertNotNull(createCustomer);
//
//        Assert.assertSame(createCustomer, this.customer);
//    }
//
//    @Test
//    public void cUpdate() {
//        String newEmailAddress = "jadek@afrocentrictechnologies.co.za";
//        Email newCustomerEmailAddress = EmailFactory.getEmail(newEmailAddress);
//
//        Customer updated = new Customer.Builder().Copy(getSaved()).email(newCustomerEmailAddress).build();
//        System.out.println("In update, updated: " + updated);
//        this.repository.update(updated);
//
//        Assert.assertSame(newCustomerEmailAddress,updated.getEmail());
//    }
//
//    @Test
//    public void bRead() {
//        Customer savedCustomer = getSaved();
//        Customer read = this.repository.read(savedCustomer.getCustomerId());
//        System.out.println("In read, read = " + read);
//
//        Assert.assertSame(read,savedCustomer);
//    }
//
//    @Test
//    public void eDelete() {
//        Customer saved = getSaved();
//        this.repository.delete(saved.getCustomerId());
//
//        System.out.println("In array after delete: " + repository.getAll());
//
//        Assert.assertEquals(0,this.repository.getAll().size());
//    }
//}