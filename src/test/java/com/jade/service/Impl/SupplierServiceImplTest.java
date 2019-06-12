package com.jade.service.Impl;

import com.jade.domain.Address;
import com.jade.domain.Contact;
import com.jade.domain.Email;
import com.jade.domain.Supplier;
import com.jade.factory.AddressFactory;
import com.jade.factory.ContactFactory;
import com.jade.factory.EmailFactory;
import com.jade.factory.SupplierFactory;
import com.jade.repository.impl.SupplierRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder
        (MethodSorters.NAME_ASCENDING)
public class SupplierServiceImplTest {

    private SupplierRepositoryImpl repository;
    private Supplier supplier;

    String supplierName = "Unilever";
    String cellContact = "0315702000";
    String workContact = "0860572908";
    String homeContact = "0215273700";
    String street = "Summer Greens Milnerton";
    String city = "Cape Town";
    String region = "Western Cape";
    String postalCode = "8001";
    String emailAddress = "consumer.affairs-za@unilever.com";

    Contact contact = ContactFactory.getContact(cellContact,workContact,homeContact);
    Address address = AddressFactory.getAddress(street,city,region,postalCode);
    Email email = EmailFactory.getEmail(emailAddress);

    private Supplier getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = SupplierRepositoryImpl.getRepository();
        this.supplier = SupplierFactory.getSupplier(supplierName,contact,address,email);
    }

    @Test
    public void dGetAll() {
        Set<Supplier> suppliers = this.repository.getAll();
        System.out.println("In getall, all: " + suppliers);

        Assert.assertEquals(1,this.repository.getAll().size());
    }

    @Test
    public void aCreate() {
        Supplier createSupplier = this.repository.create(this.supplier);
        System.out.println("In create, created: " + createSupplier);

        Assert.assertNotNull(createSupplier);

        Assert.assertSame(createSupplier, this.supplier);
    }

    @Test
    public void cUpdate() {
        String newEmailAddress = "consumer@unilever.com";
        Email newUserEmailAddress = EmailFactory.getEmail(newEmailAddress);

        Supplier updated = new Supplier.Builder().Copy(getSaved()).email(newUserEmailAddress).build();
        System.out.println("In update, updated: " + updated);
        this.repository.update(updated);

        Assert.assertSame(newUserEmailAddress,updated.getEmail());
    }

    @Test
    public void bRead() {
        Supplier savedSupplier = getSaved();
        Supplier read = this.repository.read(savedSupplier.getSupplierId());
        System.out.println("In read, read = " + read);

        Assert.assertSame(read,savedSupplier);
    }

    @Test
    public void eDelete() {
        Supplier saved = getSaved();
        this.repository.delete(saved.getSupplierId());

        System.out.println("In array after delete: " + repository.getAll());

        Assert.assertEquals(0,this.repository.getAll().size());
    }
}