package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class AccountController {


    @GetMapping("/account")
    public String account(Principal principal){
        System.out.println(principal.getName());
        return "account";
    }
}
