package com.controller;

import com.entity.*;
import com.repository.RouteRepository;
import com.repository.RouteStationRepository;
import com.repository.StationRepository;
import com.repository.TrainRepository;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class TrainFinderController {

    @Autowired
    private TrainFinderService trainFinderService;

    @Autowired
    private CityService cityService;

    @Autowired
    private StationService stationService;

    @Autowired
    private RouteStationRepository routeStationRepository;


    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private DateFormatterService dateFormatterService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String search(Model model) {
        return "index";
    }

    @RequestMapping(value = "/api/search", method = RequestMethod.POST)
    public @ResponseBody List<Train> searchRoutes(Model model, @RequestParam("firstCity") String firstCity,
                                                  @RequestParam("lastCity") String lastCity,
                                                  @RequestParam("date") String dateString){


        City fcity = cityService.findCityByName(firstCity);
        City lcity = cityService.findCityByName(lastCity);


        if(fcity == null || lcity == null) {
            return null;
        }
        Date date = null;
        try{
            date = dateFormatterService.dateFromString(dateString);
        }
        catch (ParseException pe) {

        }
        if(date == null) {
            //TODO incorrect date
            return null;
        }
        else {
            List<Train> trains = trainFinderService.searchForTrains(fcity,lcity, date);
            if(trains != null) {
                //TODO display trains

                return trains;

            }
            else {
                return null;
            }
        }

    }

}
