package com.Module1.PracticeModule1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    public  void pay(){
        System.out.println("Pay through paytm...");
    }

    @PostConstruct
    void postconstruct(){
        System.out.println("I am postconstruct ");

    }

    @PreDestroy
    void destroy(){
        System.out.println("I am preDestroy");
    }
}
