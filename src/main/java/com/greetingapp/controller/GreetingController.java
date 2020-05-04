package com.greetingapp.controller;

import com.greetingapp.model.Greeting;
import com.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/givegreeting")
    public Greeting greeting(@RequestParam(value = "firstName") String firstName,
                             @RequestParam(value = "lastName") String lastName) {
        return greetingService.greetingMessage(counter.incrementAndGet(),
                String.format(template, firstName + " " + lastName));
    }
}
