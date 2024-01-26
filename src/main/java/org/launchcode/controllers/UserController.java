package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayUserForm() {
        return "user/add";
    }
    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        model.addAttribute("verify", verify);
        if (user.getPassword().equals(verify)) {
            model.addAttribute(user);
            return "/user/index.html";
        } else {
            return "/user/add";
        }


    }
}
