package com.example.redisreview.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/login")
@RestController
public class SessionController {

    @GetMapping
    public String login(HttpSession session, @RequestParam String name) {
        session.setAttribute(session.getId(), name);

        return "saved.";
    }

    @GetMapping("/my-name")
    public String myName(HttpSession session) {
        return (String) session.getAttribute(session.getId());
    }
}
