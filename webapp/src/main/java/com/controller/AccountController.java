package com.controller;

import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class AccountController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/currentUserInfo")
    public @ResponseBody User getCurrentUserInfo(Principal principal){
        if(principal != null) {
            String username = principal.getName();
            User user = userService.findUserByName(username);
            if(user != null) {
                return user;
            }
        }
        return new User();
    }

    @GetMapping("/account")
    public String account(Principal principal){
        String username = principal.getName();
        return "account";
    }
}
