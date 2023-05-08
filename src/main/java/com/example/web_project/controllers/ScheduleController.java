package com.example.web_project.controllers;

import com.example.web_project.models.Groups;
import com.example.web_project.models.Schedule;
import com.example.web_project.models.Subjects;
import com.example.web_project.models.User;
import com.example.web_project.services.GroupService;
import com.example.web_project.services.ScheduleService;
import com.example.web_project.services.SubjectService;
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
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final UserService userService;
    private final GroupService groupService;
    private final SubjectService subjectService;

    public ScheduleController(ScheduleService scheduleService, UserService userService, GroupService groupService, SubjectService subjectService) {
        this.scheduleService = scheduleService;
        this.userService = userService;
        this.groupService = groupService;
        this.subjectService = subjectService;
    }


    @GetMapping("/Schedules")
    public String findAll(Model model){
        List<Schedule> schedules = scheduleService.findAll();
        model.addAttribute("schedules",schedules);

        List<User> users = userService.findAll();
        model.addAttribute("users",users);

        List<Groups> groups = groupService.findAll();
        model.addAttribute("groups",groups);

        List<Subjects> subjects = subjectService.findAll();
        model.addAttribute("subjects",subjects);
        return "schedule-list";
    }

    @GetMapping("/schedule-create")
    public String createUserForm(Schedule schedule){
        return "schedule-create";
    }

    @PostMapping("/schedule-create")
    public String createUser(@Valid Schedule schedule, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "schedule-create";
        }
        scheduleService.saveUser(schedule);
        return "redirect:/Schedules";
    }

    @GetMapping("/schedule-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        scheduleService.deleteById(id);
        return "redirect:/Schedules";
    }

    @GetMapping("/schedule-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        Schedule schedule = scheduleService.findById(id);
        model.addAttribute("schedule",schedule);
        return "/schedule-update";
    }

    @PostMapping("/schedule-update")
    public String updateUser(@Valid Schedule schedule, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "schedule-update";
        }
        scheduleService.saveUser(schedule);
        return "redirect:/Schedules";
    }

/*    @GetMapping("/schedule-create")
    public String createUserForm(User user){
        return "schedule-create";
    }

    @PostMapping("/schedule-create")
    public String createUser(User user,Subjects subjects,Groups groups){
        userService.saveUser(user);
        subjectService.saveUser(subjects);
        groupService.saveUser(groups);
        return "redirect:/Schedules";
    }

    @GetMapping("/schedule-delete/{id}")
    public String deleteUser(@PathVariable("id") Long user_id, @PathVariable("id") Long id){
        userService.deleteById(user_id);
        subjectService.deleteById(id);
        groupService.deleteById(id);
        return "redirect:/Schedules";
    }

    @GetMapping("/schedule-update/{id}")
    public String updateUserForm(@PathVariable("id") Long user_id,@PathVariable("id") Long id, Model model){
        User user = userService.findById(user_id);
        model.addAttribute("user",user);
        Subjects subjects = subjectService.findById(id);
        model.addAttribute("subjects", subjects);
        Groups groups = groupService.findById(id);
        model.addAttribute("groups",groups);
        return "/schedule-update";
    }

    @PostMapping("/schedule-update")
    public String updateUser(User user,Subjects subjects,Groups groups){
        userService.saveUser(user);
        subjectService.saveUser(subjects);
        groupService.saveUser(groups);
        return "redirect:/Schedules";
    }*/
}



