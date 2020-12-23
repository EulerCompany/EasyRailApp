package com.service;

import com.entity.RouteStation;
import com.repository.RouteStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteStationService {

    @Autowired
    private RouteStationRepository routeStationRepository;


    public void save(RouteStation routeStation) {
        routeStationRepository.save(routeStation);
    }
}
