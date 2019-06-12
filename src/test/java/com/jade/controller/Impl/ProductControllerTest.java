package com.jade.controller.Impl;

import com.jade.domain.Product;
import com.jade.factory.ProductFactory;
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
public class ProductControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/product";

    @Before
    public void setup(){
        Product product = ProductFactory.getProduct("Marmite", 3,50.00);
        ResponseEntity<Product> postResponse = restTemplate.postForEntity(baseURL + "/create",product,Product.class);
        System.out.println(product.getProductName());
    }

    @Test
    public void create() {
        Product product = ProductFactory.getProduct("Lucozade",6,55.60);

        ResponseEntity<Product> postResponse = restTemplate.postForEntity(baseURL + "/create/",product,Product.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        System.out.println(product.toString());
    }

    @Test
    public void update() {
        int id = 1;
        Product product = restTemplate.getForObject(baseURL + "/product/" + id, Product.class);

        restTemplate.put(baseURL + "/products/" + id, product);
        Product updatedProduct = restTemplate.getForObject(baseURL + "/Product/" + id, Product.class);
        assertNotNull(updatedProduct);
    }

    @Test
    public void delete() {
        int id = 2;
        Product product = restTemplate.getForObject(baseURL + "/products/" + id, Product.class);
        assertNotNull(product);
        restTemplate.delete(baseURL + "/products/" + id);
        try {
            product = restTemplate.getForObject(baseURL + "/products/" + id, Product.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Product product = restTemplate.getForObject(baseURL + "/product/1", Product.class);
        System.out.println(product.getProductName());
        assertNotNull(product);
    }

    @Test
    public void getAll() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());
    }
}