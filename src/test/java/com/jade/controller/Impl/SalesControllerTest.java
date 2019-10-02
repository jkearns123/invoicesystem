//package com.jade.controller.Impl;
//
//import com.jade.domain.Sales;
//import com.jade.factory.SalesFactory;
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
//public class SalesControllerTest {
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//    private String baseURL = "http://localhost:8080/sales";
//
//    @Before
//    public void setup(){
//        Sales sales = SalesFactory.getSales(150);
//        ResponseEntity<Sales> postResponse = restTemplate.postForEntity(baseURL + "/create",sales,Sales.class);
//        System.out.println(sales.getSalesTotal());
//    }
//
//    @Test
//    public void create() {
//        Sales sales = SalesFactory.getSales(60.00);
//
//        ResponseEntity<Sales> postResponse = restTemplate.postForEntity(baseURL + "/create/",sales,Sales.class);
//
//        assertNotNull(postResponse);
//        assertNotNull(postResponse.getBody());
//
//        System.out.println(sales.toString());
//    }
//
//    @Test
//    public void update() {
//        int id = 1;
//        Sales sales = restTemplate.getForObject(baseURL + "/sales/" + id, Sales.class);
//
//        restTemplate.put(baseURL + "/saless/" + id, sales);
//        Sales updatedSales = restTemplate.getForObject(baseURL + "/Sales/" + id, Sales.class);
//        assertNotNull(updatedSales);
//    }
//
//    @Test
//    public void delete() {
//        int id = 2;
//        Sales sales = restTemplate.getForObject(baseURL + "/saless/" + id, Sales.class);
//        assertNotNull(sales);
//        restTemplate.delete(baseURL + "/saless/" + id);
//        try {
//            sales = restTemplate.getForObject(baseURL + "/saless/" + id, Sales.class);
//        } catch (final HttpClientErrorException e) {
//            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @Test
//    public void read() {
//        Sales sales = restTemplate.getForObject(baseURL + "/sales/1", Sales.class);
//        System.out.println(sales.getSalesTotal());
//        assertNotNull(sales);
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