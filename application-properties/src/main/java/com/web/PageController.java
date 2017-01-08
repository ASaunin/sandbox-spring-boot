package com.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.StringJoiner;

@RestController
public class PageController {

    @Value("${pageController.message}")
    private String message;

    @Value("${randomValue.secret}")
    private String randomValue;

    @Value("${app.description}")
    private String description;

    @RequestMapping("/")
    public String home(){
        return new StringJoiner("<br>")
                .add(message)
                .add(description)
                .add("Random value: " + randomValue)
                .toString();
    }

}
