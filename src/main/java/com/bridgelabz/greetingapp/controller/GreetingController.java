package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.dto.GreetingsDTO;
import com.bridgelabz.greetingapp.exception.GreetingAppException;
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

    @GetMapping("/greeting/{id}")
    public GreetingsDTO getGreetingById(@PathVariable Long id) throws GreetingAppException {
        return greetingService.getGreetingByID(id);
    }

    @GetMapping("/getall")
    public List getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    @PostMapping("/register")
    public boolean saveGreeting(@RequestBody GreetingsDTO greetingDTO) {
        return greetingService.register(greetingDTO);
    }

    @PutMapping("/put/{id}")
    public boolean updateGreetingInfo(@PathVariable Long id, @RequestBody GreetingsDTO greetingDTO) {
        return greetingService.updateGreetingInfo(id, greetingDTO);
    }

    @DeleteMapping("/remove/{id}")
    public boolean deleteGreeting(@PathVariable Long id) {
        return greetingService.deleteGreeting(id);
    }
}
