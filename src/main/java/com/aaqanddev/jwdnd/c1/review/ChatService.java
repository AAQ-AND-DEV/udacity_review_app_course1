package com.aaqanddev.jwdnd.c1.review;

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

    public ChatService(List<ChatMessage> messages){
        this.messages = messages;
    }

//    public String uppercase(){
//        return message.toUpperCase(Locale.ROOT);
//    }
//
//    public String lowercase(){
//        return message.toLowerCase(Locale.ROOT);
//    }

    public void addMessage(ChatMessage chatMsg) {
        messages.add(chatMsg);
    }

    public List<ChatMessage> getMessages(){
        return new ArrayList<>(this.messages);
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("messageService bean created");
    }
}
