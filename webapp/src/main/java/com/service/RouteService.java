package com.service;

import com.entity.Route;
import com.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RouteService {
    @Autowired
    private RouteRepository routeRepository;


    Route findRouteByDescription(String desc) {
        return routeRepository.findByDescription(desc);
    }
}
