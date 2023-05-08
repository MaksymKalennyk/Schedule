package com.example.web_project.controllers;

import com.example.web_project.models.Subjects;
import com.example.web_project.services.SubjectService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/Subjects")
    public String findAll(Model model){
        List<Subjects> subjects = subjectService.findAll();
        model.addAttribute("subjects",subjects);
        return "subjects-list";
    }

    @GetMapping("/subjects-create")
    public String createUserForm(Subjects subjects){
        return "subjects-create";
    }

    @PostMapping("/subjects-create")
    public String createUser(@Valid Subjects subjects, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "subjects-create";
        }
        subjectService.saveUser(subjects);
        return "redirect:/Subjects";
    }

    @GetMapping("/subjects-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        subjectService.deleteById(id);
        return "redirect:/Subjects";
    }

    @GetMapping("/subjects-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        Subjects subjects = subjectService.findById(id);
        model.addAttribute("subjects",subjects);
        return "/subjects-update";
    }

    @PostMapping("/subjects-update")
    public String updateUser(@Valid Subjects subjects, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "subjects-update";
        }
        subjectService.saveUser(subjects);
        return "redirect:/Subjects";
    }
}
