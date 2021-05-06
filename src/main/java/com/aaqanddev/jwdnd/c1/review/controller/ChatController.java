package com.aaqanddev.jwdnd.c1.review.controller;

import com.aaqanddev.jwdnd.c1.review.service.ChatService;
import com.aaqanddev.jwdnd.c1.review.model.ChatForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

        //TODO fix this to use mapping
        chatService.addMessage(chatForm);
        chatForm.setMsg("");
        model.addAttribute("msgList", chatService.getMessages());
        return "chat";
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("chatcontroller instantiated");
    }

    //TODO could put the @ModelAttribute("allMessageTypes") here,
    //return an array of Enum objects? or just simple Strings
}
