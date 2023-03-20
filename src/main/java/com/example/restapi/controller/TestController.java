package com.example.restapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class TestController {
    @RequestMapping("/")
    @ResponseBody
    public String hello() {
        return "Hello Spring Boot";
    }
}
