package com.jade.service.Impl;

import com.jade.domain.Name;
import com.jade.factory.NameFactory;
import com.jade.repository.impl.NameRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder
        (MethodSorters.NAME_ASCENDING)
public class NameServiceImplTest {

    private NameRepositoryImpl repository;
    private Name name;

    String firstName = "Swae";
    String lastName = "Lee";

    private Name getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = NameRepositoryImpl.getRepository();
        this.name = NameFactory.getName(firstName,lastName);
    }

    @Test
    public void dGetAll() {
        Set<Name> names = this.repository.getAll();
        System.out.println("In getall, all: " + names);

        Assert.assertEquals(1,this.repository.getAll().size());
    }

    @Test
    public void aCreate() {
        Name createName = this.repository.create(this.name);
        System.out.println("In create, created: " + createName);

        Assert.assertNotNull(createName);

        Assert.assertSame(createName, this.name);
    }

    @Test
    public void cUpdate() {
        String newFirstName = "Bruce";
        Name updated = new Name.Builder().copy(getSaved()).firstName(newFirstName).build();
        System.out.println("In update, updated: " + updated);
        this.repository.update(updated);

        Assert.assertSame(newFirstName,updated.getFirstName());
    }

    @Test
    public void bRead() {
        Name savedName = getSaved();
        Name read = this.repository.read(savedName.getNameId());
        System.out.println("In read, read = " + read);

        Assert.assertSame(read,savedName);
    }

    @Test
    public void eDelete() {
        Name saved = getSaved();
        this.repository.delete(saved.getNameId());

        System.out.println("In array after delete: " + repository.getAll());

        Assert.assertEquals(0,this.repository.getAll().size());
    }
}