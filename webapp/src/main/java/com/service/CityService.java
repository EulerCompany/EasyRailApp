package com.service;

import com.entity.City;
import com.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;


    public boolean saveCity(City city) {
        City cityFromDb = cityRepository.findByName(city.getName());

        if(cityFromDb != null) {
            return false;
        }
        cityRepository.save(city);
        return true;
    }

    public City findCityByName(String name) {
        return cityRepository.findByName(name);
    }

}
