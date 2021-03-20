package com.market.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdditionController {
    @GetMapping("/about")
    public String aboutPage(){
        return "about";
    }
}
