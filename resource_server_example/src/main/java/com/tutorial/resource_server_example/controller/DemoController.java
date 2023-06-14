package com.tutorial.resource_server_example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping(value = "/demo")
    public String demo() {
        return "Just a demo";
    }
}
