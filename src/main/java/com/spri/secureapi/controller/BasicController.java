package com.spri.secureapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BasicController {
    @GetMapping("/")
    public String Hello(){
        return "Hello";
    }
}
