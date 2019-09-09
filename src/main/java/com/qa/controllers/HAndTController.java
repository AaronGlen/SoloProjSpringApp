package com.qa.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HAndTController {

    @RequestMapping("/")
    public String home(){
        return "hello world!";
    }
}
