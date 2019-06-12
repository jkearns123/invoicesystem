package com.jade.controller.Impl;


import com.jade.domain.Name;
import com.jade.factory.NameFactory;
import com.jade.service.NameService;
import org.apache.el.stream.Optional;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.HttpClientErrorException;

import java.net.URI;
import java.net.URISyntaxException;

import static junit.framework.TestCase.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class NameControllerTest {
//extends AbstractTest
    //************************************************************************************************************
    //**************************************************************************************************************

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/address";
    private static final String URL = "/name";

    @Before
    public void setup(){
        Name name = NameFactory.getName("Kevin","Shaw");
        ResponseEntity<Name> postResponse = restTemplate.postForEntity(baseURL + "/create",name,Name.class);
        System.out.println(name.getFirstName());
    }

    @Test
    public void create() throws Exception {

        // prepare

        Name name = NameFactory.getName("Bigsley", "Boi");

        // execute

        ResponseEntity<Name> responseEntity = restTemplate.postForEntity(URL+"/create/", name, Name.class);

        // collect Response
        int status = responseEntity.getStatusCodeValue();
        Name resultName = responseEntity.getBody();

        // verify
        assertEquals(200, status);

        assertNotNull(resultName);
        //assertNotNull(resultName.getNameId().toString());

    }

    @Test
    public void getAll() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(URL + "/read/all", HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());
    }

    @Test
    public void read() {
        Name name = restTemplate.getForObject(URL + "/name/1", Name.class);
        System.out.println(name.getFirstName());
        assertNotNull(name);
    }

    @Test
    public void update() {
        int id = 1;
        Name name = restTemplate.getForObject(URL + "/name/" + id, Name.class);

        restTemplate.put(URL + "/names/" + id, name);
        Name updatedName = restTemplate.getForObject(URL + "/Name/" + id, Name.class);
        assertNotNull(updatedName);
    }

    @Test
    public void delete() {
        int id = 2;
        Name name = restTemplate.getForObject(URL + "/names/" + id, Name.class);
        assertNotNull(name);
        restTemplate.delete(URL + "/names/" + id);
        try {
            name = restTemplate.getForObject(URL + "/names/" + id, Name.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
//**************************************************************************************************************************
    //**********************************************************************************************************************
    /*extends AbstractTest*/


    //@MockBean
   // NameService nameService;
    //HttpHeaders headers = new HttpHeaders();


    //_-------------------------------------------____________________--------------------______________________

/*    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void create() throws Exception {
        String uri = "/name/create/";

        Name name = NameFactory.getName("Bigsley", "Boi");


        String inputJson = super.mapToJson(name);
        //MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        //MvcResult mvcResult = mvc.perform(put(uri+"{foo}/{bar}", "foo", "bar"));
        //MvcResult mvcResult = mockMvc.perform(put("/some/uri/with/wildcards/{foo}/{bar}", "foo", "bar"));
        MvcResult mvcResult = mvc.perform(put(uri+"{firstName}/{lastName}", "foo", "bar"))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Product is created successfully");
    }*/

        //_-------------------------------------------____________________--------------------______________________

  /*      Name name = NameFactory.getName("Bigsley","Boi");

        ResponseEntity<Name>postResponse = restTemplate.postForEntity(baseURL + "/create/",name,Name.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        System.out.println(name.toString());*/
  //}

        //-----------------------------------------------------------
       /* URI uri = new URI(baseURL+"/create");
        Name name = NameFactory.getName("Jade","Kearns");

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST","true");

        HttpEntity<Name> request = new HttpEntity<>(name,headers);


        this.restTemplate.postForObject(uri,request,String.class);*/

        //System.out.println(result);

        //-----------------------------------------------------------
        /*Name name = NameFactory.getName("Jade","Kearns");
        HttpEntity<Name>entity = new HttpEntity<Name>(name,headers);

        ResponseEntity<String> response = restTemplate.exchange((baseURL +"/create"),
                HttpMethod.POST, entity, String.class);

        String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);*/
   // }

/*    @Test
    public void update() {
        int id = 1;
        Name name = restTemplate.getForObject(baseURL + "/name/" + id, Name.class);

        restTemplate.put(baseURL + "/names/" + id, name);
        Name updatedName = restTemplate.getForObject(baseURL + "/Name/" + id, Name.class);
        assertNotNull(updatedName);
    }

    @Test
    public void delete() {
        int id = 2;
        Name name = restTemplate.getForObject(baseURL + "/names/" + id, Name.class);
        assertNotNull(name);
        restTemplate.delete(baseURL + "/names/" + id);
        try {
            name = restTemplate.getForObject(baseURL + "/names/" + id, Name.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Name name = restTemplate.getForObject(baseURL + "/name/1", Name.class);
        System.out.println(name.getFirstName());
        assertNotNull(name);
    }

    @Test
    public void getAll() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all", HttpMethod.GET, entity, String.class);

        assertNotNull(response.getBody());
    }*/
}