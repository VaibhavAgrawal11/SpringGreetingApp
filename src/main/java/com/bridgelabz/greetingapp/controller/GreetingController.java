package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.dto.GreetingsDTO;
import com.bridgelabz.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GreetingController {
    @Autowired
    GreetingService greetingService;

    @RequestMapping(value = {"", "home", "/"})
    public String sayHii() {
        return greetingService.homeGreetings();
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return greetingService.greetingMessage(name);
    }

    @GetMapping("/getall")
    public List getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    @PostMapping("/register")
    public boolean saveGreeting(@RequestBody GreetingsDTO greetingDTO) {
        return greetingService.register(greetingDTO);
    }
}
