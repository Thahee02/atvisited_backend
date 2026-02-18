package com.atvisited.atvisited.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {
    @GetMapping("/")
    String healthCheck(){
        return "Welcome atvisited!";
    }
}
