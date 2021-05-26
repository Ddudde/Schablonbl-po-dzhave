package com.demo;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HtmlController {

    @RequestMapping("/")
    public String index(Model model, String name) {
        model.addAttribute("name", name);
        return "Hello";
    }
}