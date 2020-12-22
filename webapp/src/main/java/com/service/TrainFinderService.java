package com.service;

import com.entity.City;
import com.entity.Route;
import com.entity.Train;
import com.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TrainFinderService {

    @Autowired
    private RouteRepository routeRepository;


    public List<Train> searchForTrains(City firstCity, City lastCity, Date date) {


        return null;
    }

}
