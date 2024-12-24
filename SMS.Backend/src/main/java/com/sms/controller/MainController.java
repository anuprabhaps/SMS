package com.sms.controller;
import com.sms.model.Result;
import com.sms.model.Student;
import com.sms.repository.ResultRepository;
import com.sms.repository.StudentRepository;
import com.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ResultRepository resultRepository;

    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/users")
    public String users(Model model,@RequestParam String email) {
        Student users = studentRepository.findByEmail(email);
        model.addAttribute("users", users);
        return "users";
    }
    @GetMapping("/result")
    public String result(Model model,@RequestParam int id) {
        List<Result> result = resultRepository.findAll();
        model.addAttribute("result", result);
        return "result";
    }
    }


