package com.asaunin.controller;

import com.asaunin.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/persons")
    public String viewPersons(Model model) {
        model.addAttribute("persons", personService.findAll());
        return "person/list";
    }

}
