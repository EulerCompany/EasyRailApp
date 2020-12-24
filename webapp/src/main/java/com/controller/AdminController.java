package com.controller;

import com.entity.*;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private CityService cityService;

    @Autowired
    private StationService stationService;

    @Autowired
    private TrainService trainService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private DateFormatterService dateFormatterService;

    @Autowired
    private SeedingService seedingService;

    @Autowired
    private RouteService routeService;

    @GetMapping("/api/allUsers")
    public @ResponseBody List<User> userList(Model model) {
        return userService.allUsers();
    }

    @GetMapping("/api/deleteUser")
    public @ResponseBody ResponseEntity<Long>  deleteUser(@RequestParam(required = true, defaultValue = "" ) Long userId) {
        if(userService.deleteUser(userId)) {
            return new ResponseEntity<>(userId,HttpStatus.OK);
        }
        return new ResponseEntity<>(userId, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/admin/gt/{userId}")
    public String  gtUser(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("allUsers", userService.usergtList(userId));
        return "admin";
    }

    @RequestMapping(value = "/api/addCity", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> addCity(@RequestParam("name") String name) {
        if(cityService.saveCity(name)) {
            return new ResponseEntity<>("City was added", HttpStatus.OK);
        }

        return new ResponseEntity<>("City already in table", HttpStatus.CONFLICT);
    }

    @RequestMapping(value = "/api/addStation", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> addStation(@RequestParam String cityName,
                             @RequestParam String stationName) {

        City city = cityService.findCityByName(cityName);
        Station station = new Station(stationName);

        if(stationService.addStationIfCityExists(city, station)) {
            cityService.saveCity(city);
            return new ResponseEntity<>("Station was added", HttpStatus.OK);
        }
        else{
            cityService.saveCity(cityName);
            station.setCity(cityService.findCityByName(cityName));
            stationService.saveStation(station);
            return new ResponseEntity<>("City and station was added", HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/api/addTrain", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> addTrain(@RequestParam String trainName,
                           @RequestParam("a") String arrivalTime,
                           @RequestParam("d") String departureTime,
                           @RequestParam("r") String routeId) {

        Optional<Route> route = routeService.findById(Long.valueOf(routeId));
        if(route.isEmpty()) {
            return new ResponseEntity<>("No such route", HttpStatus.BAD_REQUEST);
        }
        try {
            if(trainService.saveTrain(trainName,
                    dateFormatterService.dateFromString(departureTime),
                    dateFormatterService.dateFromString(arrivalTime),
                    route.get())){
                return new ResponseEntity<>("Train was added", HttpStatus.OK);

            }
        }
        catch (ParseException pe) {
            pe.printStackTrace();
        }
        return new ResponseEntity<>("Train is not added", HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/api/addTicket", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> addTicket(@RequestParam Double price,
                            @RequestParam String ticketClass,
                            @RequestParam(defaultValue = "Service") String username,
                            @RequestParam String trainName) {

        Ticket ticket = new Ticket();
        ticket.setPrice(price);
        ticket.setTicketClass(ticketClass);
        User service = userService.findUserByName(username);
        ticket.setUser(service);
        Train train = trainService.findByTrainName(trainName);

        if(train != null) {
            ticket.setTrain(train);
            ticketService.saveTicket(ticket);
            return new ResponseEntity<>("Ticket was added", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Train does not exist", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/api/seed")
    public ResponseEntity<String> seed() {

        seedingService.seed();
        return new ResponseEntity<>("Seeded", HttpStatus.OK);
    }
}