package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.GreetingsDTO;
import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    UserRepository userRepository;

    public String homeGreetings() {
        return "Hello World";
    }

    public String greetingMessage(String name) {
        return "Hello " + name;
    }

    public boolean register(GreetingsDTO greetingDTO) {
        greetingDTO.setGreetingMessage("Hello " + greetingDTO.getFirstName() + " " + greetingDTO.getLastName());
        Greeting greeting = modelMapper.map(greetingDTO, Greeting.class);
        userRepository.save(greeting);
        return true;
    }

    public List getAllGreetings() {
        return userRepository.findAll();
    }
}
