//package com.jade.controller.Impl;
//
//import com.jade.domain.*;
//import com.jade.factory.*;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.*;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.web.client.HttpClientErrorException;
//
//import static org.junit.Assert.*;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@RunWith(SpringRunner.class)
//public class CustomerControllerTest {
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//    private String baseURL = "http://localhost:8080/customer";
//
//    Name name = NameFactory.getName("Olivia","Kearns");
//    Address address = AddressFactory.getAddress("37 Chelmsford road","Cape Town","Western","8001");
//    Contact contact = ContactFactory.getContact("06154646450","4665233256","0218796545");
//    Email email = EmailFactory.getEmail("beetfruit@gmail.com");
//
//    @Before
//    public void setup(){
//
//        Customer customer = CustomerFactory.getCustomer(name,address,contact,email);
//        ResponseEntity<Customer> postResponse = restTemplate.postForEntity(baseURL + "/create",customer,Customer.class);
//        System.out.println(postResponse.toString());
//    }
//
//    @Test
//    public void create() {
//        Name name = NameFactory.getName("Olivie","Shaw");
//        Address address = AddressFactory.getAddress("37 Chelmsford Road Unit 2","Cape Town","Western Cape","7580");
//        Contact contact = ContactFactory.getContact("0713078199","0214651513","0219039881");
//        Email email = EmailFactory.getEmail("livybeatfruit@gmail.com");
//
//        Customer customer = CustomerFactory.getCustomer(name,address,contact,email);
//
//        ResponseEntity<Customer> postResponse = restTemplate.postForEntity(baseURL + "/create/",customer,Customer.class);
//
//        assertNotNull(postResponse);
//        assertNotNull(postResponse.getBody());
//
//        System.out.println(customer.toString());
//    }
//
//    @Test
//    public void update() {
//        int id = 1;
//        Customer customer = restTemplate.getForObject(baseURL + "/customer/" + id, Customer.class);
//
//        restTemplate.put(baseURL + "/customers/" + id, customer);
//        Customer updatedCustomer = restTemplate.getForObject(baseURL + "/Customer/" + id, Customer.class);
//        assertNotNull(updatedCustomer);
//    }
//
//    @Test
//    public void delete() {
//        int id = 2;
//        Customer customer = restTemplate.getForObject(baseURL + "/customers/" + id, Customer.class);
//        assertNotNull(customer);
//        restTemplate.delete(baseURL + "/customers/" + id);
//        try {
//            customer = restTemplate.getForObject(baseURL + "/customers/" + id, Customer.class);
//        } catch (final HttpClientErrorException e) {
//            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @Test
//    public void read() {
//        Customer customer = restTemplate.getForObject(baseURL + "/customer/1", Customer.class);
//        System.out.println(customer.getAddress());
//        assertNotNull(customer);
//    }
//
//    @Test
//    public void getAll() {
//        HttpHeaders headers = new HttpHeaders();
//
//        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);
//
//        assertNotNull(response.getBody());
//    }
//}