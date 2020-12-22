package com.controller;

import com.entity.City;
import com.entity.Station;
import com.service.CityService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private CityService cityService;


    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        return "admin";
    }

    @PostMapping("/admin")
    public String  deleteUser(@RequestParam(required = true, defaultValue = "" ) Long userId,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            userService.deleteUser(userId);
        }
        return "redirect:/admin";
    }

    @GetMapping("/admin/gt/{userId}")
    public String  gtUser(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("allUsers", userService.usergtList(userId));
        return "admin";
    }

    @RequestMapping(value = "/admin/addCity", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> addCity(@RequestParam("name") String name) {
        if(cityService.saveCity(name)) {
            return new ResponseEntity<>("City was added", HttpStatus.CREATED);
        }

        return new ResponseEntity<>("City already in table", HttpStatus.CONFLICT);
    }
}