package com.service;

import com.entity.*;
import com.repository.RouteRepository;
import com.repository.RouteStationRepository;
import com.repository.TrainRepository;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TrainFinderService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private RouteStationRepository routeStationRepository;

    @Autowired
    private TrainRepository trainRepository;

    public List<Train> searchForTrains(City firstCity, City lastCity, Date date) {

        //pick two stations
        //in project we have 1 to 1 relationship between city and station
        Station firstCityStations = firstCity.getFirstStation();
        Station lastCityStations = lastCity.getFirstStation();



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

        List<Train> trains  = new ArrayList<>();

        for(Long id : routeIds) {
            Train train = trainRepository.getTrainByRouteId(id);
            try{
                if(train.getDepartureDate() == date) {
                    trains.add(train);
                }
            }
            catch (ParseException pe){
                System.out.println("Parse Exception near searching for trains");
            }
        }
        return trains;
    }

}
