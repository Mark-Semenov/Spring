package ru.geekbrains.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.entities.Role;
import ru.geekbrains.entities.User;
import ru.geekbrains.service.UserService;

@Controller
@RequestMapping("/admin")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public String getAllUsers(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }


    @Secured({"ROLE_SUPER_ADMIN"})
    @GetMapping("/users/add")
    public String addNewUser(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("role", new Role());
        return "newuser";
    }


    @PostMapping("/users/add")
    public String addUser(User user){
        userService.saveOrUpdate(user);
        return "redirect:/admin/users";
    }

}
