package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Properties;

@Component
@Scope("prototype")
public class MailService implements MessageService{

    @PostConstruct
    public void init(){
        System.out.println("MailService objesi oluşturuluyor");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("MailService objesi imha edildi");
    }



    private Repository repo;

    @Autowired
    public MailService(@Qualifier("fileRepository") Repository repo) {
        this.repo = repo;
    }

    @Override
    public void sendMessage(Message message) {
        System.out.println("Ben bir Mail servisiyim. Mesajınız: "+message.getMessage());
    }

    @Override
    public void saveMessage(Message message) {
       
        repo.save(message);

    }
}
