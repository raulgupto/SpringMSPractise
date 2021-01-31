package com.springmspractise.api.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackCircuitBreakerController {

    @GetMapping("/userServiceFallback")
    public String userServiceFallback(){
        return "Request is taking more time, Server might be down";
    }
    @GetMapping("/movieServiceFallback")
    public String movieServiceFallback(){
        return "Request is taking more time, Server might be down";
    }
    @GetMapping("/departmentServiceFallback")
    public String departmentServiceFallback(){
        return "Request is taking more time, Server might be down";
    }


}
