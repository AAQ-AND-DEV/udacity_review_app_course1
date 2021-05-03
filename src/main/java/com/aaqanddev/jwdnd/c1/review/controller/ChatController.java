package com.aaqanddev.jwdnd.c1.review.controller;

import com.aaqanddev.jwdnd.c1.review.ChatService;
import com.aaqanddev.jwdnd.c1.review.model.ChatForm;
import com.aaqanddev.jwdnd.c1.review.model.ChatMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.Locale;

@Controller
public class ChatController {

    private ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/chat")
    public String getChatPage(@ModelAttribute("chatForm") ChatForm chatForm, Model model){
        System.out.println("getMapping Called for chat.html");
        model.addAttribute("msgList", chatService.getMessages());
        return "chat";
    }

    @PostMapping("/chat")
    public String postChatPage(@ModelAttribute("chatForm") ChatForm chatForm, Model model){
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
        chatService.addMessage(new ChatMessage(chatForm.getUsername(), alteredMsg));
        chatForm.setMsg("");
        chatForm.setUsername("");
        model.addAttribute("msgList", chatService.getMessages());
        return "chat";
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("chatcontroller instantiated");
    }
}
