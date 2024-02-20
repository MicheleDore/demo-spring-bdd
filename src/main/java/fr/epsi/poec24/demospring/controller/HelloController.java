package fr.epsi.poec24.demospring.controller;

import fr.epsi.poec24.demospring.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloController {

    private HelloService service;

    @Autowired
    public HelloController(HelloService service) {
        this.service = service;
    }

    public String getGreeting() {
        return service.greeting();
    }
}
