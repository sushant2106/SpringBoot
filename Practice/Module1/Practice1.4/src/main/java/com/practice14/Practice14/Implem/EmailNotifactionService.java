package com.practice14.Practice14.Implem;

import com.practice14.Practice14.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
@Qualifier("Email")
public class EmailNotifactionService implements NotificationService {

    @Override
    public  void send(String message){
        System.out.println("Email sending " + message);
    }
}
