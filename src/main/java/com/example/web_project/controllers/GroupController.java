package com.example.web_project.controllers;

import com.example.web_project.models.Groups;
import com.example.web_project.services.GroupService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/Groups")
    public String findAll(Model model){
        List<Groups> groups = groupService.findAll();
        model.addAttribute("groups",groups);
        return "group-list";
    }

    @GetMapping("/group-create")
    public String createFacultyForm(Groups groups){
        return "group-create";
    }

    @PostMapping("/group-create")
    public String createUser(@Valid Groups groups,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "group-create";
        }
        groupService.saveUser(groups);
        return "redirect:/Groups";
    }

    @GetMapping("/group-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        groupService.deleteById(id);
        return "redirect:/Groups";
    }

    @GetMapping("/group-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        Groups groups = groupService.findById(id);
        model.addAttribute("groups",groups);
        return "/group-update";
    }

    @PostMapping("/group-update")
    public String updateUser(@Valid Groups groups, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "group-update";
        }
        groupService.saveUser(groups);
        return "redirect:/Groups";
    }
}
