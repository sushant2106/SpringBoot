package com.myown.module1Introduction;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Component
public class PayementService {

    public  void pay(){
        System.out.println("I am pay ");
    }

    @PostConstruct
    public  void afterInitialize(){
        System.out.println("Before Paying..");
    }

    @PreDestroy
    public  void beforedestro(){
        System.out.println("After Payment is done ...");
    }

}
