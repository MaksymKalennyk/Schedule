package com.example.web_project.controllers;

import com.example.web_project.models.Department;
import com.example.web_project.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DepartmentController {

    private final DepartmentService departmentService;


    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }


    @GetMapping("/Departments")
    public String findAll(Model model){
        List<Department> department = departmentService.findAll();
        model.addAttribute("department",department);
        return "department-list";
    }

    @GetMapping("/department-create")
    public String createFacultyForm(Department department){
        return "department-create";
    }

    @PostMapping("/department-create")
    public String createUser(@Valid Department department,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "department-create";
        }
        departmentService.saveUser(department);
        return "redirect:/Departments";
    }

    @GetMapping("/department-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        departmentService.deleteById(id);
        return "redirect:/Departments";
    }

    @GetMapping("/department-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        Department department = departmentService.findById(id);
        model.addAttribute("department",department);
        return "/department-update";
    }

    @PostMapping("/department-update")
    public String updateUser(@Valid Department department, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "department-update";
        }
        departmentService.saveUser(department);
        return "redirect:/Departments";
    }
}
