package com.aaqanddev.jwdnd.c1.review.service;

import com.aaqanddev.jwdnd.c1.review.mapper.MessageMapper;
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
    //do not need this messages variable
    //private List<ChatMessage> messages;
    private MessageMapper msgMapper;

    public ChatService(MessageMapper msgMapper) {
        this.msgMapper = msgMapper;
    }

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
        // attain id from insert (do anything with it?)
        int id = msgMapper.insertMessage(new ChatMessage(null, chatForm.getUsername(), alteredMsg));
    }

    public List<ChatMessage> getMessages(){
        return new ArrayList<>(msgMapper.getMessages());
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("messageService bean created");
        //this.messages = msgMapper.getMessages();
    }
}
