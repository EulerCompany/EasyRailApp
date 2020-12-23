package com.service;

import com.entity.City;
import com.entity.Station;
import com.repository.CityRepository;
import com.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private CityRepository cityRepository;


    public boolean saveStation(Station station) {

        if(stationRepository.findByStationName(station.getStationName()) != null) {
            return false;
        }
        stationRepository.save(station);
        return true;
    }
    public Station findStationByCityName(String cityName) {
        return stationRepository.findByCityName(cityName);
    }


    public boolean addStationIfCityExists(City city, Station station) {

        if(city != null) {

            List<Station> stations = city.getStations();
            if(stations != null) {
                if(stations.contains(station)) {
                    return false;
                }
                else {
                    station.setCity(city);
                    saveStation(station);
                    stations.add(station);
                    city.setStations(stations);
                    return true;
                }
            }
            else {
                station.setCity(city);
                saveStation(station);
                return true;
            }

        }
        return false;
    }

    public Station findStationByCityId(City city) {
        return stationRepository.findByCityId(city.getId());
    }

}
