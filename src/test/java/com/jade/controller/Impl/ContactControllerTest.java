package com.jade.controller.Impl;

import com.jade.domain.Contact;
import com.jade.factory.ContactFactory;
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
public class ContactControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/contact";

    @Before
    public void setup(){
        Contact contact = ContactFactory.getContact("0713078199", "0214661513","0219039881");
        ResponseEntity<Contact> postResponse = restTemplate.postForEntity(baseURL + "/create",contact,Contact.class);
        System.out.println(contact.getCellContact());
    }

    @Test
    public void create() {
        Contact contact = ContactFactory.getContact("0713561234","0214563232","0112053689");

        ResponseEntity<Contact> postResponse = restTemplate.postForEntity(baseURL + "/create/",contact,Contact.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        System.out.println(postResponse.toString());
    }

    @Test
    public void update() {
        int id = 1;
        Contact contact = restTemplate.getForObject(baseURL + "/contact/" + id, Contact.class);

        restTemplate.put(baseURL + "/contacts/" + id, contact);
        Contact updatedContact = restTemplate.getForObject(baseURL + "/Contact/" + id, Contact.class);
        assertNotNull(updatedContact);
    }

    @Test
    public void delete() {
        int id = 1;
        Contact contact = restTemplate.getForObject(baseURL + "/contacts/" + id, Contact.class);
        assertNotNull(contact);
        restTemplate.delete(baseURL + "/contacts/" + id);
        try {
            contact = restTemplate.getForObject(baseURL + "/contacts/" + id, Contact.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Contact contact = restTemplate.getForObject(baseURL + "/contact/1", Contact.class);
        System.out.println(contact.getCellContact());
        assertNotNull(contact);
    }

    @Test
    public void getAll() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());
    }
}