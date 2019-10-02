package com.jade.controller.customer;

import com.jade.domain.*;
import com.jade.factory.*;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder
        (MethodSorters.NAME_ASCENDING)
public class CustomersControllerTest {

    Name name = NameFactory.getName("John","Doe");
    Address address = AddressFactory.getAddress("Chelm Road","Down Town","Eastern Cape","7580");
    Contact contact = ContactFactory.getContact("0612058149","0214161516","0219039881");
    Email email = EmailFactory.getEmail("jdoe@gmail.com");

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/invoicesystem/customer";

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void a_createOK() {
        HttpHeaders headers = new HttpHeaders();

        Customer customer = CustomerFactory.getCustomer(name,address,contact,email,null);
        HttpEntity<Customer> entity = new HttpEntity<Customer>(customer,headers);


        ResponseEntity<Customer> postResponse = restTemplate.withBasicAuth("user","password").postForEntity(baseURL + "/create/",entity,Customer.class);

        assertNotNull(postResponse);
        assertEquals(HttpStatus.OK,postResponse.getStatusCode());
        System.out.println(postResponse.getStatusCode() + " " + postResponse.getStatusCodeValue());

        System.out.println(customer.toString());

    }

    @Test
    public void b_createADMINOK() {
        HttpHeaders headers = new HttpHeaders();


        Customer customer = CustomerFactory.getCustomer(name,address,contact,email,null);
        HttpEntity<Customer> entity = new HttpEntity<Customer>(customer,headers);


        ResponseEntity<Customer> postResponse = restTemplate.withBasicAuth("admin","admin").postForEntity(baseURL + "/create/",entity,Customer.class);

        assertNotNull(postResponse);
        assertEquals(HttpStatus.OK,postResponse.getStatusCode());
        System.out.println(postResponse.getStatusCode() + " " + postResponse.getStatusCodeValue());

        System.out.println(customer.toString());

    }



    @Test
    public void c_getAllOK() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth("user","password").exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);


        assertEquals(HttpStatus.OK,response.getStatusCode());

        System.out.println(response.getStatusCode());
    }

    @Test
    public void d_getAllUNAUTHORIZED() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth("user","dsfs").exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);


        assertEquals(HttpStatus.UNAUTHORIZED,response.getStatusCode());
        System.out.println(response.getStatusCode());
    }

    @Test
    public void e_readOK() {

        HttpEntity<String> request = new HttpEntity<String>(CorrectCredentials());
        ResponseEntity<Customer> response = restTemplate.exchange(baseURL+"/read/1", HttpMethod.GET, request, Customer.class);
        Customer customer = response.getBody();

        assertEquals(HttpStatus.OK,response.getStatusCode());
        System.out.println(response.getStatusCode());

    }

    @Test
    public void f_readUNAUTHORIZED() {

        HttpEntity<String> request = new HttpEntity<String>(IncorrectCredentials());
        ResponseEntity<Customer> response = restTemplate.exchange(baseURL+"/read/1", HttpMethod.GET, request, Customer.class);
        Customer customer = response.getBody();

        assertEquals(HttpStatus.UNAUTHORIZED,response.getStatusCode());
        System.out.println(response.getStatusCode());

    }

    @Test
    public void h_deleteOK() {

        HttpEntity<String> request = new HttpEntity<String>(CorrectCredentials());
        ResponseEntity<Customer> response = restTemplate.exchange(baseURL+"/delete/1", HttpMethod.DELETE, request, Customer.class);
        System.out.println(response.getStatusCode());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,response.getStatusCode());

    }

    @Test
    public void g_updateOK(){

        HttpHeaders headers = new HttpHeaders();
        Customer customer = CustomerFactory.getCustomer(name,address,contact,email,null);

        HttpEntity<Customer> entity = new HttpEntity<Customer>(customer, headers);

        ResponseEntity<String> postResponse = restTemplate.exchange(baseURL + "/update",HttpMethod.PUT,entity, String.class);

        System.out.println(postResponse.getStatusCode());
        assertEquals(HttpStatus.OK,postResponse.getStatusCode());
    }



    private static HttpHeaders CorrectCredentials(){
        String plainCredentials="admin:admin";
        String base64Credentials = new String(Base64.encodeBase64(plainCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }

    private static HttpHeaders IncorrectCredentials(){
        String plainCredentials="admin:sdf";
        String base64Credentials = new String(Base64.encodeBase64(plainCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }
}