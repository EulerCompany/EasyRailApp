package com.service;

import com.entity.Route;
import com.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;


    public Route findRouteByDescription(String desc) {
        return routeRepository.findByDescription(desc);
    }

    public boolean save(Route route) {
        Route routeFromDb = routeRepository.findByDescription(route.getDescription());

        if(routeFromDb != null) {
            return false;
        }

        routeRepository.save(route);
        return true;
    }

    public Optional<Route> findById(Long id){
        return routeRepository.findById(id);
    }
}
