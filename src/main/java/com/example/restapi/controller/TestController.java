package com.example.restapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class TestController {
    private static final String appName = "CRUD Alumnos";
    @RequestMapping("/")
    public String hello(Model model) {
        model.addAttribute("pageName", appName);
        return "homepage";
    }
}
