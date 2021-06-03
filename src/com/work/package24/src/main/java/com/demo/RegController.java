package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegController {

    @Autowired
    private UserService userService;

    @GetMapping("/reg")
    public String registration(Model model) {
        model.addAttribute("new_user", new User());
        return "reg";
    }

    @PostMapping("/reg")
    public String addUser(@ModelAttribute("new_user") @Valid User new_user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "reg";
        }
        if (!new_user.getPassword().equals(new_user.getPasswordConfirm())){
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "reg";
        }
        if (!userService.saveUser(new_user)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "reg";
        }
        return "redirect:/";
    }
}
