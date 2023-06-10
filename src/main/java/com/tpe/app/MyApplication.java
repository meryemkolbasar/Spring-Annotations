package com.tpe.app;

import com.tpe.AppConfiguration;
import com.tpe.domain.Message;
import com.tpe.service.MailService;
import com.tpe.service.MessageService;
import com.tpe.service.SmsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;

public class MyApplication {
    public static void main(String[] args) {

        Message message=new Message();
        message.setMessage("Spring ile çalışmak HARİKA olacak;)");

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfiguration.class);
       



        SmsService service3=context.getBean(SmsService.class);
        service3.sendMessage(message);
        service3.printContact();
        service3.printProperties();


        context.close();


    }
}
