package com.jade.controller.Impl;

import com.jade.domain.Address;
import com.jade.factory.AddressFactory;
import org.junit.Before;
import org.junit.Ignore;
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
public class AddressControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/address";

    @Before
    public void setup(){
        Address address = AddressFactory.getAddress("40 Excelsior street", "Kuilsriver","Western Cape","7580");
        ResponseEntity<Address> postResponse = restTemplate.postForEntity(baseURL + "/create",address,Address.class);
        System.out.println(address.getStreet());
    }

    @Test
    public void create() {
        Address address = AddressFactory.getAddress("37 Chelms road","Cape town","Western Cape","7580");

        ResponseEntity<Address> postResponse = restTemplate.postForEntity(baseURL + "/create/",address,Address.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        System.out.println(address.toString());
    }

    @Test
    public void update() {
        int id = 1;
        Address address = restTemplate.getForObject(baseURL + "/address/" + id, Address.class);

        restTemplate.put(baseURL + "/addresss/" + id, address);
        Address updatedAddress = restTemplate.getForObject(baseURL + "/Address/" + id, Address.class);
        assertNotNull(updatedAddress);
    }

    @Ignore
    public void delete() {
        int id = 2;
        Address address = restTemplate.getForObject(baseURL + "/addresss/" + id, Address.class);
        assertNotNull(address);
        restTemplate.delete(baseURL + "/addresss/" + id);
        try {
            address = restTemplate.getForObject(baseURL + "/addresss/" + id, Address.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Address address = restTemplate.getForObject(baseURL + "/address/1", Address.class);
        System.out.println(address.getStreet());
        assertNotNull(address);
    }

    @Test
    public void getAll() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());
    }
}