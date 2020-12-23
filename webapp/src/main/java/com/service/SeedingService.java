package com.service;

import com.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

@Service
public class SeedingService {

    @Autowired
    private CityService cityService;

    @Autowired
    private UserService userService;

    @Autowired
    private StationService stationService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private RouteStationService routeStationService;

    @Autowired
    private DateFormatterService dateFormatterService;

    @Autowired
    private TrainService trainService;

    @Autowired
    private TicketService ticketService;

    public void seed() {
        seedUsers();
        seedCities();
        seedRoutes();
        seedTrainsAndTickets();

    }
    private void seedRoutes() {
        List<String> firstRouteList = Arrays.asList("Львів", "Житомир","Біла Церква", "Київ", "Кременчук", "Дніпро", "Харків", "Маріуполь");
        List<String> secondRouteList = new ArrayList<>(firstRouteList);
        Collections.reverse(secondRouteList);
        List<String> thirdRouteList = Arrays.asList("Київ", "Кременчук", "Дніпро", "Маріуполь");

        Route firstRoute = new Route();
        firstRoute.setFirstStation(firstRouteList.get(0));
        firstRoute.setLastStation(firstRouteList.get(firstRouteList.size()-1));
        firstRoute.setDescription("Route 1");
        routeService.save(firstRoute);

        Route secondRoute = new Route();
        secondRoute.setFirstStation(secondRouteList.get(0));
        secondRoute.setLastStation(secondRouteList.get(secondRouteList.size()-1));
        secondRoute.setDescription("Route 2");
        routeService.save(secondRoute);

        Route thirdRoute = new Route();
        thirdRoute.setFirstStation(thirdRouteList.get(0));
        thirdRoute.setLastStation(thirdRouteList.get(thirdRouteList.size()-1));
        thirdRoute.setDescription("Route 3");
        routeService.save(thirdRoute);

        addRouteStation(firstRouteList, "Route 1");
        addRouteStation(secondRouteList, "Route 2");
        addRouteStation(thirdRouteList, "Route 3");
    }

    private void addRouteStation(List<String> routeList, String routeDesc) {
        Route curRoute = routeService.findRouteByDescription(routeDesc);
        Long i = 1L;
        for(String cityName: routeList) {
            Station station = stationService.findStationByCityName(cityName);
            RouteStation routeStation = new RouteStation(curRoute, station, i);
            routeStationService.save(routeStation);
            ++i;
        }
    }

    private void seedTrainsAndTickets() {

        addTrainAndTickets("2020-11-01", "2020-11-02", "Route 1", "T1");
        addTrainAndTickets("2020-11-01", "2020-11-02", "Route 2", "T2");
        addTrainAndTickets("2020-11-01", "2020-11-02", "Route 3", "T3");
    }
    private void addTrainAndTickets(String departureDate, String arrivalDate, String description, String trainName) {
        Route route = routeService.findRouteByDescription(description);
        Train train = new Train();
//        List<String> departureDates = Arrays.asList(departureDate);
//        List<String> arrivalDates = Arrays.asList(arrivalDate);
        try{
            Date depDate = dateFormatterService.dateFromString(departureDate);
            Date arDate = dateFormatterService.dateFromString(arrivalDate);

            train.setArrivalTime(arDate);
            train.setDepartureTime(depDate);
            train.setTrainName(trainName);
            train.setRoute(route);
            trainService.saveTrain(train);

            for(int i = 0; i < 10; ++i) {
                Ticket ticket = new Ticket();
                ticket.setPrice(200.0 + i * 30);
                ticket.setTicketClass("premium");
                train = trainService.findByTrainName(trainName);
                ticket.setTrain(train);
                User service = userService.findUserByName("Service");
                ticket.setUser(service);
                ticketService.saveTicket(ticket);
            }
        }catch (ParseException pe) {
            pe.printStackTrace();
        }

    }

    private void seedStation(String cityName){
        City city = cityService.findCityByName(cityName);
        Station station = new Station("Станція " + cityName);
        stationService.addStationIfCityExists(city,station);
    }

    private void seedCities() {
        List<String> cities = Arrays.asList("Маріуполь", "Біла Церква", "Київ", "Кременчук", "Львів", "Житомир", "Харків", "Дніпро");
        for(String city : cities) {
            cityService.saveCity(city);
            seedStation(city);
        }
    }

    private void seedUsers() {
        List<String> usernames = Arrays.asList("Wozzya", "HauntTheHouse", "lammaxcool", "ayy_lma0","Service");
        List<String> password = Arrays.asList("pass", "pass" , "pass", "pass", "pass");
        List<String> firstName = Arrays.asList("Vladyslav", "Roman", "Max", "Daria", "Ser");
        List<String> lastName = Arrays.asList("Chaykovsky", "Durda", "Haponuk", "Kharitonova", "Vice");

        for(int i = 0; i <usernames.size(); ++i) {
            User user = new User(usernames.get(i),
                                 firstName.get(i),
                                 lastName.get(i),
                                 password.get(i));

            userService.saveUser(user);
        }
    }
}
