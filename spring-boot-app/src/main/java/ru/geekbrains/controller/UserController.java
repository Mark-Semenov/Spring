package ru.geekbrains.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.entities.Role;
import ru.geekbrains.entities.User;
import ru.geekbrains.service.RoleRepository;
import ru.geekbrains.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }


    @Secured({"ROLE_SUPER_ADMIN"})
    @GetMapping("/users/add")
    public String addNewUser(Model model) {
        User user = new User();
        Role role = new Role();

        model.addAttribute("user", user);
        model.addAttribute("role", role);
        model.addAttribute("roles", roleRepository.findAll());
        return "newuser";
    }


    @PostMapping("/users/add")
    public String addUser(User user, Role role) {
        List<Role> roles = new ArrayList<>();
        user.setPassword(encoder.encode(user.getPassword()));
        roles.add(roleRepository.findByTitle(role.getTitle()));
        user.setRoles(roles);
        userService.saveOrUpdate(user);
        return "redirect:/admin/users";
    }

}
