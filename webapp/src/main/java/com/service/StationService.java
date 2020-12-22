package com.service;

import com.entity.Station;
import com.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationService {

    @Autowired
    private StationRepository stationRepository;

    public boolean saveStation(Station station) {

        if(stationRepository.findByStationName(station.getStationName()) != null) {
            return false;
        }
        stationRepository.save(station);
        return true;
    }

}
