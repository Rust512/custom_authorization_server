package com.tutorial.resource_server_example.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping(value = "/demo")
    public String demo(Authentication authentication) {
        return "Just a demo";
    }
}
