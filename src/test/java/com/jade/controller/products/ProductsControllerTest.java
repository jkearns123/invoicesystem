package com.jade.controller.products;

import com.jade.domain.Product;
import com.jade.factory.ProductFactory;
import com.jade.repository.ProductRepository;
import com.jade.repository.impl.ProductRepositoryImpl;
import org.apache.tomcat.util.codec.binary.Base64;
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
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.Set;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder
        (MethodSorters.NAME_ASCENDING)
public class ProductsControllerTest {



    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/invoicesystem/product";

    @Before
    public void setUp() throws Exception {

    }



    @Test
    public void a_createFORBIDDEN() {
        HttpHeaders headers = new HttpHeaders();
        Product product = ProductFactory.getProduct("Lucozade",6,55.60);
        HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);


        ResponseEntity<Product> postResponse = restTemplate.withBasicAuth("user","password").postForEntity(baseURL + "/create/",entity,Product.class);

        assertNotNull(postResponse);
        assertEquals(HttpStatus.FORBIDDEN,postResponse.getStatusCode());
        System.out.println(postResponse.getStatusCode() + " " + postResponse.getStatusCodeValue());

        System.out.println(product.toString());

    }

    @Test
    public void b_createOK() {
        HttpHeaders headers = new HttpHeaders();
        Product product = ProductFactory.getProduct("Enegade",4,35.60);
        HttpEntity<Product> entity = new HttpEntity<Product>(product,headers);


        ResponseEntity<Product> postResponse = restTemplate.withBasicAuth("admin","admin").postForEntity(baseURL + "/create/",entity,Product.class);

        assertNotNull(postResponse);
        assertEquals(HttpStatus.OK,postResponse.getStatusCode());
        System.out.println(postResponse.getStatusCode() + " " + postResponse.getStatusCodeValue());


    }

    @Test
    public void c_getAllOK() {

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth("admin","admin").exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);

        //assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK,response.getStatusCode());
        //System.out.println(response.getBody());
        System.out.println(response.getStatusCode());


    }

    @Test
    public void d_getAllUNAUTHORIZED() {

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth("admin","asd").exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);

        System.out.println(response.getStatusCode());
        assertEquals(HttpStatus.UNAUTHORIZED,response.getStatusCode());



    }

    @Test
    public void d_getAllFORBIDDEN() {

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth("user","password").exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);

        System.out.println(response.getStatusCode());
        assertEquals(HttpStatus.FORBIDDEN,response.getStatusCode());



    }


    @Test
    public void e_readOK() {

        HttpEntity<String> request = new HttpEntity<String>(CorrectCredentials());
        ResponseEntity<Product> response = restTemplate.exchange(baseURL+"/read/1", HttpMethod.GET, request, Product.class);
        Product product = response.getBody();

        assertEquals(HttpStatus.OK,response.getStatusCode());
        System.out.println(response.getStatusCode());

    }

    @Test
    public void f_readUNAUTHORIZED() {

        HttpEntity<String> request = new HttpEntity<String>(IncorrectCredentials());
        ResponseEntity<Product> response = restTemplate.exchange(baseURL+"/read/1", HttpMethod.GET, request, Product.class);
        Product product = response.getBody();

        assertEquals(HttpStatus.UNAUTHORIZED,response.getStatusCode());
        System.out.println(response.getStatusCode());

    }


    @Test
    public void h_deleteOK() {

        HttpEntity<String> request = new HttpEntity<String>(CorrectCredentials());
        ResponseEntity<Product> response = restTemplate.exchange(baseURL+"/delete/1", HttpMethod.DELETE, request, Product.class);
        System.out.println(response.getStatusCode());
        assertEquals(HttpStatus.OK,response.getStatusCode());

    }

    @Test
    public void g_updateOK(){

        HttpHeaders headers = new HttpHeaders();
        Product product = ProductFactory.getProduct("Lucozade",6,55.60);

        HttpEntity<Product> entity = new HttpEntity<Product>(product, headers);

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