package com.aaqanddev.jwdnd.c1.review.service;

import com.aaqanddev.jwdnd.c1.review.model.ChatForm;
import com.aaqanddev.jwdnd.c1.review.model.ChatMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class ChatService {
    private String message;

    private List<ChatMessage> messages;

//    public String uppercase(){
//        return message.toUpperCase(Locale.ROOT);
//    }
//
//    public String lowercase(){
//        return message.toLowerCase(Locale.ROOT);
//    }

    public void addMessage(ChatForm chatForm) {
        int type = chatForm.getType();
        String currMsg = chatForm.getMsg();
        String alteredMsg = currMsg;
        //0 - say, 1- shout, 2 -whisper
        switch (type) {
            case 0 -> {
                break;
            }
            case 1 -> {
                alteredMsg = currMsg.toUpperCase(Locale.ROOT);
                break;
            }
            case 2 -> {
                alteredMsg = currMsg.toLowerCase(Locale.ROOT);
                break;
            }
        }
        //TODO hardcoding id here -- when transition to db, will attain id from insert
        messages.add(new ChatMessage(-1, chatForm.getUsername(), alteredMsg));
    }

    public List<ChatMessage> getMessages(){
        return new ArrayList<>(this.messages);
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("messageService bean created");
        this.messages = new ArrayList<>();
    }
}
