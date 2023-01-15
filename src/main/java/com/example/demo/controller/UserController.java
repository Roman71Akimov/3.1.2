package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;




@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController (UserService userService){
        this.userService = userService;
    }
    @GetMapping
    public String showAllUsers(Model model){
        model.addAttribute("allUsers", userService.showAllUsers());
        return "show";
    }
    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "create";
    }
    @PostMapping
    public String createUser(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/users";
    }
    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id")  Long id,  Model model){
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }
    @PostMapping("/{id}")
    public String saveEditUser(@ModelAttribute(name = "user") User user){
        userService.update(user);
        return "redirect:/users";
    }

    @PostMapping("/{id}/delete")
    public String deleteUser(@PathVariable(name = "id") Long id ){
        userService.delete(id);
        return "redirect:/users";
    }


}


