package com.example.web_project.controllers;

import com.example.web_project.models.Students;
import com.example.web_project.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentsController {

    private final StudentService studentService;

    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/Students")
    public String findAll(Model model){
        List<Students> students = studentService.findAll();
        model.addAttribute("students",students);
        return "students-list";
    }

    @GetMapping("/students-create")
    public String createUserForm(Students students){
        return "students-create";
    }

    @PostMapping("/students-create")
    public String createUser(@Valid Students students,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "students-create";
        }
        studentService.saveUser(students);
        return "redirect:/Students";
    }

    @GetMapping("/students-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        studentService.deleteById(id);
        return "redirect:/Students";
    }
    @GetMapping("/students-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        Students students = studentService.findById(id);
        model.addAttribute("students",students);
        return "/students-update";
    }

    @PostMapping("/students-update")
    public String updateUser(@Valid Students students, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "students-update";
        }
        studentService.saveUser(students);
        return "redirect:/Students";
    }
}
