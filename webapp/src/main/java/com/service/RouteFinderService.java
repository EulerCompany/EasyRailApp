package com.service;

import com.entity.Route;
import com.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteFinderService {

    @Autowired
    private RouteRepository routeRepository;


}
