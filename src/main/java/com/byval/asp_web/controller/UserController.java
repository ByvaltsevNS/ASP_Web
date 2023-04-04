package com.byval.asp_web.controller;

import com.byval.asp_web.model.User;
import com.byval.asp_web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String getUsers(Model model) {

        userRepository.saveAll(List.of(
                new User(
                        "Nikolai",
                        "Byvaltsev",
                        "byvaltsev@email.com",
                        "730814",
                        "7308"
                )
        ));

        model.addAttribute("users", userRepository.findAll());

        return "user";
    }

    @PostMapping
    public String addNewUser (@RequestParam String firstName,
                              @RequestParam String lastName,
                              @RequestParam String email,
                              @RequestParam String groupId,
                              @RequestParam String studentId) {

        userRepository.save(new User(firstName, lastName, email, groupId, studentId));
        return "user";
    }
}
