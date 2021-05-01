package com.aaqanddev.jwdnd.c1.review;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Locale;

@Service
public class MessageService {
    private String message;

    public MessageService(String message){
        this.message = message;
    }

    public String uppercase(){
        return message.toUpperCase(Locale.ROOT);
    }

    public String lowercase(){
        return message.toLowerCase(Locale.ROOT);
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("messageService bean created");
    }
}
