package com.jade.controller.Impl;

import com.jade.domain.Email;
import com.jade.factory.EmailFactory;
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
public class EmailControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/email";

    @Before
    public void setup(){

        Email email = EmailFactory.getEmail("Beatfruit@gmail.com");
        ResponseEntity<Email> postResponse = restTemplate.postForEntity(baseURL + "/create",email,Email.class);
        System.out.println(postResponse.toString());
    }

    @Test
    public void create() {
        Email email = EmailFactory.getEmail("jkearns123@gmail.com");

        ResponseEntity<Email> postResponse = restTemplate.postForEntity(baseURL + "/create/",email,Email.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        System.out.println(email.toString());
    }

    @Test
    public void update() {
        int id = 1;
        Email email = restTemplate.getForObject(baseURL + "/email/" + id, Email.class);

        restTemplate.put(baseURL + "/emails/" + id, email);
        Email updatedEmail = restTemplate.getForObject(baseURL + "/Email/" + id, Email.class);
        assertNotNull(updatedEmail);
    }

    @Ignore
    public void delete() {
        int id = 2;
        Email email = restTemplate.getForObject(baseURL + "/emails/" + id, Email.class);
        assertNotNull(email);
        restTemplate.delete(baseURL + "/emails/" + id);
        try {
            email = restTemplate.getForObject(baseURL + "/emails/" + id, Email.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Email email = restTemplate.getForObject(baseURL + "/email/1", Email.class);
        System.out.println(email.getEmailAddress());
        assertNotNull(email);
    }

    @Test
    public void getAll() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());
    }
}