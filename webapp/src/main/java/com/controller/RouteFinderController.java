package com.controller;

import com.service.CityService;
import com.service.RouteFinderService;
import com.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class RouteFinderController {

    @Autowired
    private RouteFinderService routeFinderService;

    @Autowired
    private CityService cityService;

    @Autowired
    private StationService stationService;

    @GetMapping("/search")
    public String search(Model model) {

        return "search";

    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchRoutes(@RequestParam("first_name") String firstName,
                               @RequestParam("second_name") String secondName) {

        //TODO search and return routes

        return "redirect:/search";
    }


}
