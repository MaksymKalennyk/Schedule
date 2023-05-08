package com.example.web_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FAQController {
    @GetMapping("/FAQ")
    public String findAll(Model model){
        return "FAQ";
    }
}
