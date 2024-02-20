package fr.epsi.poec24.demospring.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String greeting() {
        return "Hello, world from service!";
    }
}
