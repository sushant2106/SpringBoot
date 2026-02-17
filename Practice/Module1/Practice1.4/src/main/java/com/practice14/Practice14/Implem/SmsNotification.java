package com.practice14.Practice14.Implem;

import com.practice14.Practice14.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary
@Component
@Qualifier("Sms")
public class SmsNotification implements NotificationService {

    @Override
    public  void send(String message){
        System.out.println("Sms sending.." + message);
    }
}
