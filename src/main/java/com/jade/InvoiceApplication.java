package com.jade;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//when the application starts up spring boot will look through all packages that are in the project looking for the controller,
//controller should be annotated - create a class, annotate it as a controller
//(C)controller - controls communication between the (M)model - the data  and (V)view - user interface (that which consumes the service) "MVC"
//MVC is championed by SpringframeWork
@SpringBootApplication
public class InvoiceApplication {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[]args){
        SpringApplication.run(InvoiceApplication.class, args);
    }
}
