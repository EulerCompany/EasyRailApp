package com.controller;

import com.entity.*;
import com.repository.RouteRepository;
import com.repository.RouteStationRepository;
import com.repository.StationRepository;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private RouteRepository routeRepository;
    @Autowired
    private StationRepository stationRepository;

    @GetMapping("/search")
    public String search(Model model) {

        return "search";
    }

    //TODO reformat
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchRoutes(@RequestParam("first_name") String firstName,
                               @RequestParam("second_name") String secondName,
                               @RequestParam("date") String date){


        Route route = routeRepository.findByDescription("ROMA ROMA");
        var stations  = route.getStations();
        for(RouteStation rs: stations) {
            System.out.println(rs.getOrder());
        }

        //TODO proper date formation...roma poimet
        Date departureDate = new Date();
        try {
            departureDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            System.out.println(departureDate);
        }
        catch (ParseException pe){

        }
        City firstCity = cityService.findCityByName(firstName);
        City lastCity = cityService.findCityByName(secondName);

        if(firstCity == null || lastCity == null) {
            return "No rides available";
        }

        List<Station> firstCityStations = firstCity.getStations();
        List<Station> lastCityStations = lastCity.getStations();

        Station fstation = firstCityStations.get(0);
        Station lstation = lastCityStations.get(0);

        Route froute = fstation.getRoutes().get(0).getRoute();
        Route lroute = lstation.getRoutes().get(0).getRoute();

        if(froute.getId().equals(lroute.getId())){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }

//        for(Station fstation: firstCityStations) {
//
//            for (Station lstation: lastCityStations) {
//
//            }
//        }




        List<Train> trains = trainFinderService.searchForTrains(firstCity, lastCity, departureDate);



        return "redirect:/search";
    }


}
