package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.dto.GreetingsDTO;
import com.bridgelabz.greetingapp.exception.GreetingAppException;
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

    public GreetingsDTO getGreetingByID(Long id) throws GreetingAppException {
        Greeting greeting = userRepository.getOne(id);
        if (greeting == null)
            throw new GreetingAppException("DATA NOT FOUND", GreetingAppException.ExceptionType.INVALID_ID);
        GreetingsDTO greetingDTO = modelMapper.map(greeting, GreetingsDTO.class);
        return greetingDTO;
    }

    public List getAllGreetings() {
        return userRepository.findAll();
    }
}
