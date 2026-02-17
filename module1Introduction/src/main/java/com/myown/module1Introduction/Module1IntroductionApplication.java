package com.myown.module1Introduction;

import com.myown.module1Introduction.Impl.EmailNotifcationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Module1IntroductionApplication implements CommandLineRunner {

//    @Autowired
//    PayementService payementService1;
//
//    @Autowired
//    PayementService payementService2;

//    @Autowired
 final NotificationService notificationService; //dependency Injection


    public  Module1IntroductionApplication(NotificationService notificationService){
        this.notificationService=notificationService;//constructor way of doing DI
    }

//    public  Module1IntroductionApplication(@Qualifier("SmsNotif") NotificationService notificationService){
//        this.notificationService=notificationService;//constructor way of doing DI
//    }

    Map<String,NotificationService> notificationServiceMap=new HashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(Module1IntroductionApplication.class, args);

//        PayementService payementService=new PayementService();
//        payementService.pay();
	}


//    @Override
//    public  void  run(String[] args) throws  Exception{
//
//        System.out.println(payementService1.hashCode());
//        System.out.println(payementService2.hashCode());
//        payementService1.pay();
//        payementService2.pay();
//    }

    //lec 1.4

    @Override
    public  void run(String[] args) throws  Exception{
//        NotificationService notificationService=(message)->{
//            System.out.println("Sending sms .."+message);
//        };
//
//        notificationService.send("Airtel-Jio");
//
//        NotificationService notificationService=new EmailNotifcationService();
        notificationService.send("Jio");

        for(var notificationService: notificationServiceMap.entrySet()){
            System.out.println(notificationService.getKey());
            notificationService.getValue().send("Hello...");
        }



    }
}
