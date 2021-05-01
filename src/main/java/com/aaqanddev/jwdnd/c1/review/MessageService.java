package com.aaqanddev.jwdnd.c1.review;

import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MessageService {
    private String message;

    public MessageService(String message){
        System.out.println("messageService bean created");
        this.message = message;
    }

    public String uppercase(){
        return message.toUpperCase(Locale.ROOT);
    }

    public String lowercase(){
        return message.toLowerCase(Locale.ROOT);
    }
}
