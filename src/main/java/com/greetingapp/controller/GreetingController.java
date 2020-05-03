package com.greetingapp.controller;

import com.greetingapp.model.Greeting;
import com.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    String template = "Hello %s!";
    AtomicLong counter = new AtomicLong();

    @Autowired
    GreetingService greetingService;

    @RequestMapping(value = {"", "home", "/"})
    public String sayHii() {
        return greetingService.homeGreetings();
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return greetingService.greetingMessage(counter.incrementAndGet(),
                String.format(template, name));
    }
}
