package com.aaqanddev.jwdnd.c1.review.controller;

import com.aaqanddev.jwdnd.c1.review.security.IAuthFacade;
import com.aaqanddev.jwdnd.c1.review.service.AuthenticationService;
import com.aaqanddev.jwdnd.c1.review.service.ChatService;
import com.aaqanddev.jwdnd.c1.review.model.ChatForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Locale;

@Controller
public class ChatController {

    private final ChatService chatService;
    @Autowired
    private IAuthFacade authFacade;

    @RequestMapping(value="/username", method= RequestMethod.GET)
    @ResponseBody
    public String currentUserNameSimple(){
        Authentication auth = authFacade.getAuthentication();
        return auth.getName();
    }

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

        //get username of loggin-in user via AuthFacade
        String username = currentUserNameSimple();
        //set username on chatForm
        chatForm.setUsername(username);
        //chat service now uses mapping to insert to db
        chatService.addMessage(chatForm);
        chatForm.setMsg("");
        // updating messages for view after insert
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
