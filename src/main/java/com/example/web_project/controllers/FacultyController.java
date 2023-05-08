package com.example.web_project.controllers;

import com.example.web_project.models.Faculty;
import com.example.web_project.services.FacultyService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("/faculty")
    public String findAll(Model model){
        List<Faculty> faculty = facultyService.findAll();
        model.addAttribute("faculty",faculty);
        return "faculty-list";
    }

    @GetMapping("/faculty-create")
    public String createFacultyForm(Faculty faculty){
        return "faculty-create";
    }

    @PostMapping("/faculty-create")
    public String createUser(@Valid Faculty faculty, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "faculty-create";
        }
        facultyService.saveUser(faculty);
        return "redirect:/faculty";
    }

    @GetMapping("/faculty-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        facultyService.deleteById(id);
        return "redirect:/faculty";
    }

    @GetMapping("/faculty-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        Faculty faculty = facultyService.findById(id);
        model.addAttribute("faculty",faculty);
        return "/faculty-update";
    }

    @PostMapping("/faculty-update")
    public String updateUser(@Valid Faculty faculty, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "faculty-update";
        }
        facultyService.saveUser(faculty);
        return "redirect:/faculty";
    }
}
