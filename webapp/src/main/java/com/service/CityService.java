package com.service;

import com.entity.City;
import com.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;


    public boolean saveCity(String cityName) {
        City cityFromDb = cityRepository.findByName(cityName);

        if(cityFromDb != null) {
            return false;
        }
        City city = new City();
        city.setName(cityName);
        cityRepository.save(city);
        return true;
    }
    public boolean saveCity(City city) {

        if(cityRepository.existsById(city.getId())) {
            return false;
        }
        cityRepository.save(city);
        return true;
    }

    public City findCityByName(String name) {
        return cityRepository.findByName(name);
    }

}
