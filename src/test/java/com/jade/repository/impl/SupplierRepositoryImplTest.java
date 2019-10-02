//package com.jade.repository.impl;
//
//import com.jade.domain.*;
//import com.jade.factory.*;
//import com.jade.domain.Supplier;
//import org.junit.*;
//import org.junit.runners.MethodSorters;
//
//import static org.junit.Assert.*;
//
////The FixMethodOrder class allows the user to choose the order of execution of the methods within a test class
//@FixMethodOrder
//        (MethodSorters.NAME_ASCENDING)
//public class SupplierRepositoryImplTest {
//
//    private SupplierRepositoryImpl repository;
//    private Supplier supplier;
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
//    private Supplier getTestSupplier(){
//
//        //String name = NameFactory.getName(supplierName);
//        Address address = AddressFactory.getAddress(street,city,region,postalCode);
//        Contact contact = ContactFactory.getContact(supplierContact,supplierWorkContact,"");
//        Email email = EmailFactory.getEmail(supplierEmail);
//
//        return SupplierFactory.getSupplier(supplierName,contact,address,email);
//    }
//
//    private Supplier getSavedSupplier(){
//        return this.repository.getAll().iterator().next();
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        this.repository = (SupplierRepositoryImpl) SupplierRepositoryImpl.getRepository();
//        this.supplier = getTestSupplier();
//    }
//
//    @Test
//    public void aCreate() {
//        Supplier savedSupplier = this.repository.create(this.supplier);
//
//        System.out.println("Created record:\n**************");
//        System.out.println(savedSupplier);
//
//        Assert.assertNotNull(savedSupplier);
//    }
//
//
//    @Test
//    public void bRead() {
//        Supplier testSupplier = getSavedSupplier();
//        Supplier readSupplier = this.repository.read(testSupplier.getSupplierId());
//
//        System.out.println("Read record:\n**************");
//
//        System.out.println("Saved Record: " + testSupplier);
//        System.out.println("Read Record: " + readSupplier);
//
//        Assert.assertSame(testSupplier,readSupplier);
//    }
//
//    @Test
//    public void cUpdate() {
//        String updateEmail = "emailchanged@changeisgood.com";
//
//        Email updateSupplierEmail = EmailFactory.getEmail(updateEmail);
//
//        Supplier supplier = getSavedSupplier();
//        Supplier copyOfSupplier = new Supplier.Builder().Copy(supplier).email(updateSupplierEmail).build();
//        Supplier updatedSupplier = this.repository.update(copyOfSupplier);
//
//        System.out.println("Update record:\n**************");
//        System.out.println("Previous Record: " + supplier);
//        System.out.println("Updated Record: " + updatedSupplier);
//
//        Assert.assertNotNull(updatedSupplier);
//        Assert.assertNotEquals(supplier.getEmail(),updatedSupplier.getEmail());
//        Assert.assertEquals(supplier.getSupplierName(),updatedSupplier.getSupplierName());
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
//
//        Supplier supplier = getSavedSupplier();
//        this.repository.delete(supplier.getSupplierId());
//
//        System.out.println("Delete record:\n**************");
//
//        System.out.println("Current record: " + supplier);
//        System.out.println("Deleted: " + this.repository.getAll());
//
//        Assert.assertEquals(0,this.repository.getAll().size());
//    }
//}