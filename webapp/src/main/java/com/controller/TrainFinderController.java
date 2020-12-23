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

    @GetMapping("/search")
    public String search(Model model) {

        return "search";
    }

    //TODO reformat
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchRoutes(@RequestParam("first_name") String firstName,
                               @RequestParam("second_name") String secondName,
                               @RequestParam("date") String date){


//        Route route = routeRepository.findByDescription("ROMA ROMA");
//        var stations  = route.getStations();
//        for(RouteStation rs: stations) {
//            System.out.println(rs.getOrder());
//        }

        //TODO proper date formation...roma poimet
//        Date departureDate = new Date();
//        try {
//            departureDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
//            System.out.println(departureDate);
//        }
//        catch (ParseException pe){
//
//        }
        City firstCity = cityService.findCityByName(firstName);
        City lastCity = cityService.findCityByName(secondName);
        System.out.println("after city");
        if(firstCity == null || lastCity == null) {
            return "No rides available";
        }



        Station firstCityStations = firstCity.getFirstStation();
        Station lastCityStations = lastCity.getFirstStation();


        System.out.println(firstCityStations.getStationName());
        System.out.println(lastCityStations.getStationName());


        List<RouteStation> rt1 = routeStationRepository.findByStationId(firstCityStations.getId());
        List<RouteStation> rt2 = routeStationRepository.findByStationId(lastCityStations.getId());

        List<Long> routeIds = new ArrayList<>();


        for(RouteStation t : rt1) {
            for(RouteStation tt : rt2){
                if(t.getRoute().getId() == tt.getRoute().getId() && t.getOrder()  < tt.getOrder()) {
                    routeIds.add(t.getRoute().getId());
                }
            }
        }

        for(Long l : routeIds) {
            Train train = trainRepository.getTrainByRouteId(l);
            System.out.println(train.getTrainName());
        }





        return "redirect:/search";
    }


}
