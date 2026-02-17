package com.Module1.PracticeModule1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {



    @Bean
    PaymentService paymentService(){
        System.out.println("I am AppConfig...");
        return new PaymentService();
    }




}
