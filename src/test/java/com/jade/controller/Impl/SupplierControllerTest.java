package com.jade.controller.Impl;

import com.jade.domain.Address;
import com.jade.domain.Contact;
import com.jade.domain.Email;
import com.jade.domain.Supplier;
import com.jade.factory.AddressFactory;
import com.jade.factory.ContactFactory;
import com.jade.factory.EmailFactory;
import com.jade.factory.SupplierFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class SupplierControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/supplier";

    Contact contact = ContactFactory.getContact("03164646156","56568656532","02165824569");
    Address address = AddressFactory.getAddress("40 nowghad land","South Park","Landings","8568");
    Email email = EmailFactory.getEmail("jj@gmail.com");

    @Before
    public void setup(){
        Supplier supplier = SupplierFactory.getSupplier("Bakomo", contact,address,email);
        ResponseEntity<Address> postResponse = restTemplate.postForEntity(baseURL + "/create",address,Address.class);
        System.out.println(address.getStreet());
    }

    @Test
    public void create() {

        Address address = AddressFactory.getAddress("Summer Geens Dve","Milnerton","Western Cape","7441");
        Contact contact = ContactFactory.getContact("0860331441","0860330006","0860314151");
        Email email = EmailFactory.getEmail("consumer.affairs-za@unilever.com");

        Supplier supplier = SupplierFactory.getSupplier("Unilever",contact,address,email);

        ResponseEntity<Supplier> postResponse = restTemplate.postForEntity(baseURL + "/create/",supplier,Supplier.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        System.out.println(supplier.toString());
    }

    @Test
    public void update() {
        int id = 1;
        Supplier supplier = restTemplate.getForObject(baseURL + "/supplier/" + id, Supplier.class);

        restTemplate.put(baseURL + "/suppliers/" + id, supplier);
        Supplier updatedSupplier = restTemplate.getForObject(baseURL + "/Supplier/" + id, Supplier.class);
        assertNotNull(updatedSupplier);
    }

    @Test
    public void delete() {
        int id = 2;
        Supplier supplier = restTemplate.getForObject(baseURL + "/suppliers/" + id, Supplier.class);
        assertNotNull(supplier);
        restTemplate.delete(baseURL + "/suppliers/" + id);
        try {
            supplier = restTemplate.getForObject(baseURL + "/suppliers/" + id, Supplier.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Supplier supplier = restTemplate.getForObject(baseURL + "/supplier/1", Supplier.class);
        System.out.println(supplier.getSupplierName());
        assertNotNull(supplier);
    }

    @Test
    public void getAll() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());
    }
}