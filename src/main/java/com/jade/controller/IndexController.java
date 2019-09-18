package com.jade.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//when someone hits your end point - the root of your end point is the domain - (eg.www.xyz.com) when someone hits the root of the endpoint you need to give a index.page

//different types of controllers, however im using restControl for a rest application,
//spring boot will go through the appliaction and files - will detect that this file is annotated with @RestController
@RestController
public class IndexController {

//if i run localhost:8080/
    @GetMapping("/")
    @ResponseBody
    public ResponseEntity getHome(){
        return new ResponseEntity("Welcome to Invoice System", HttpStatus.OK);
    }
}
