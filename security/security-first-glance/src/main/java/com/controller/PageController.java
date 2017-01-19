package com.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PageController {

    @RequestMapping("/guest")
    public String guest() {
        return "This page should be available for everyone... But it doesn't work for somehow!";
    }

    @RequestMapping("/user")
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public String user() {
        return "This page is available only for authorised users";
    }

    @RequestMapping("/admin")
    @Secured("ROLE_ADMIN")
    public String admin() {
        return "This page is available only for admins";
    }

}
