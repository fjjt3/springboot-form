package com.springboot.form.app.controllers;

import com.springboot.form.app.models.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("title", "Users Forms");
        return "form";
    }

    @PostMapping("/form")
    public String ProcessForm(Model model,
                              @RequestParam String username,
                              @RequestParam String password,
                              @RequestParam String  email){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        model.addAttribute("title", "Form Result");
        model.addAttribute("user", user);

        return "result";
    }
}
