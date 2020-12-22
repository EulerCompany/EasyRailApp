package com.controller;

import com.entity.City;
import com.entity.Station;
import com.service.CityService;
import com.service.StationService;
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

    @Autowired
    private StationService stationService;

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
    @RequestMapping(value = "/admin/addStation", method = RequestMethod.GET)
    @ResponseBody
    public String addStation(@RequestParam String cityName,
                             @RequestParam String stationName) {

        City city = cityService.findCityByName(cityName);
        Station station = new Station();
        station.setStationName(stationName);

        if(city != null){
            List<Station> stations = city.getStations();

            if(stations.contains(station)) {
                return "Station exist";
            }
            else {
                station.setCity(city);
                stationService.saveStation(station);
                stations.add(station);
                city.setStations(stations);
                cityService.saveCity(city);
            }

            return "Station was added";
        }
        else {
            cityService.saveCity(cityName);
            station.setCity(cityService.findCityByName(cityName));
            stationService.saveStation(station);
            return "City and station was added";
        }

    }
}