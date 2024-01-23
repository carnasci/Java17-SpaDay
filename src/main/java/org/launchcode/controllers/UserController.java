package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping
    public String displayUserForm() {
        return "user/add";
    }
    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {

        if (user.getPassword().equals(verify)) {
            model.addAttribute(user);
            return "redirect:";
        } else {
            return "user/add";
        }


    }
}
