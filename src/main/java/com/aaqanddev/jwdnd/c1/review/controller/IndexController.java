package com.aaqanddev.jwdnd.c1.review.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class IndexController {

    public String getIndex(){
        return "index";
    }
}
