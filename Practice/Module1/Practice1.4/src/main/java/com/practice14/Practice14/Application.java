package com.practice14.Practice14;

import com.practice14.Practice14.Implem.EmailNotifactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application  implements CommandLineRunner {

//    @Autowired
//    PaymentService paymentService;
//
//    public  Application(PaymentService paymentService){
//        this.paymentService=paymentService;
//    }

//    @Autowired
//    EmailNotifactionService emailNotifactionService;

    final  NotificationService notificationService;

    public  Application(@Qualifier("Email") NotificationService notificationService){
        this.notificationService=notificationService;
    }


	public static void main(String[] args)  {
		SpringApplication.run(Application.class, args);
	}
//
//    @Override
//    public  void run(String[] args) throws  Exception{
//        emailNotifactionService.send("gmail");
//
//    }

//    @Override
//    public  void run(String[] args) throws  Exception{
//        paymentService.pay();
//    }

    @Override
    public  void run(String[] args){
        notificationService.send("JIO..LGAA DALA ");
    }

}
