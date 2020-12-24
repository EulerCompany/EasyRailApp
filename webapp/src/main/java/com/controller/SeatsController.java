package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class SeatsController {


    @GetMapping("/seats")
    public String seats(Principal principal){
        return "seats";
    }
}
