package com.controller;

import com.entity.Route;
import com.service.CityService;
import com.service.RouteFinderService;
import com.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.DataOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
                               @RequestParam("second_name") String secondName,
                               @RequestParam("date") String date){


        try {
            Date routeDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            System.out.println(routeDate);
        }
        catch (ParseException pe){

        }

        //TODO search and return routes


        return "mlogin";
    }


}
