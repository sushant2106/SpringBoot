package com.practice14.Practice14;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

//@Component
public class PaymentService {

    public  void pay(){
        System.out.println("I am pay ");
    }

    @PostConstruct
    public  void post_get(){
        System.out.println("Intialization of Bean");
    }

    @PreDestroy
    public void  pre_destroy(){
        System.out.println("Object is done");
    }

}
