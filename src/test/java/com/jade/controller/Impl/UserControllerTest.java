package com.jade.controller.Impl;

import com.jade.domain.Contact;
import com.jade.domain.Email;
import com.jade.domain.Name;
import com.jade.domain.User;
import com.jade.factory.ContactFactory;
import com.jade.factory.EmailFactory;
import com.jade.factory.NameFactory;
import com.jade.factory.UserFactory;
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
public class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/user";

    Name name = NameFactory.getName("Olivia","Kearns");
    Contact contact = ContactFactory.getContact("06154646450","4665233256","0218796545");
    Email email = EmailFactory.getEmail("beetfruit@gmail.com");

    @Before
    public void setup(){

        User user = UserFactory.getUser(name,contact,email);
        ResponseEntity<User> postResponse = restTemplate.postForEntity(baseURL + "/create",user,User.class);
        System.out.println(user.getName());
    }

    @Test
    public void create() {

        Name name = NameFactory.getName("River","Coldpepper");
        Contact contact = ContactFactory.getContact("0746545566","0114561513","0118569922");
        Email email = EmailFactory.getEmail("livybeatfruit@gmail.com");

        User user = UserFactory.getUser(name,contact,email);

        ResponseEntity<User> postResponse = restTemplate.postForEntity(baseURL + "/create/",user,User.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        System.out.println(user.toString());
    }

    @Test
    public void update() {
        int id = 1;
        User user = restTemplate.getForObject(baseURL + "/user/" + id, User.class);

        restTemplate.put(baseURL + "/users/" + id, user);
        User updatedUser = restTemplate.getForObject(baseURL + "/User/" + id, User.class);
        assertNotNull(updatedUser);
    }

    @Test
    public void delete() {
        int id = 2;
        User user = restTemplate.getForObject(baseURL + "/users/" + id, User.class);
        assertNotNull(user);
        restTemplate.delete(baseURL + "/users/" + id);
        try {
            user = restTemplate.getForObject(baseURL + "/users/" + id, User.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        User user = restTemplate.getForObject(baseURL + "/user/1", User.class);
        System.out.println(user.getName());
        assertNotNull(user);
    }

    @Test
    public void getAll() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());
    }
}