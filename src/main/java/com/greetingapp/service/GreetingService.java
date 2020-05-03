package com.greetingapp.service;

import com.greetingapp.model.Greeting;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String homeGreetings() {
        return "Hello World";
    }

    public Greeting greetingMessage(long count, String greetings) {
        return new Greeting(count, greetings);
    }
}
