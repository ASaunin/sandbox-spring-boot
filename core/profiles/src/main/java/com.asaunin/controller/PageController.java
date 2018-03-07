package com.asaunin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {

    @Value("${message}")
    private String message;

    @RequestMapping("/")
    public String hello() {
        return message;
    }

}
