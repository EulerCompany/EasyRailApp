package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class CartController {


    @GetMapping("/cart")
    public String cart(Principal principal){
        return "cart";
    }
}
