package com.example.web_project.controllers;


import com.example.web_project.models.User;
import com.example.web_project.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(@Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "user-create";
        }
        userService.saveUser(user);
         return "redirect:/users";
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long user_id){
        userService.deleteById(user_id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{user_id}")
    public String updateUserForm(@PathVariable("user_id") Long user_id, Model model){
        User user = userService.findById(user_id);
        model.addAttribute("user",user);
        return "/user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(@Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "user-update";
        }
        userService.saveUser(user);
        return "redirect:/users";
    }
}
