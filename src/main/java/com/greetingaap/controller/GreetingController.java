package com.greetingaap.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @RequestMapping(value = {"", "home", "/"})
    public String sayHii() {
        return "Welcome to Greeting Application With Spring..!";
    }
}
