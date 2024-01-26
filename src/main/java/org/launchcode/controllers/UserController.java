package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("email", user.getEmail());
        model.addAttribute("username", user.getUsername());
        return "user/add";
    }
    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify, String email,
                                     String username) {
        model.addAttribute("verify", verify);

        if (user.getPassword().equals(verify)) {
            model.addAttribute(user);
            return "/user/index.html";
        } else {
            model.addAttribute("error", "Password not verified!");
            return "/user/add";
        }


    }
}
