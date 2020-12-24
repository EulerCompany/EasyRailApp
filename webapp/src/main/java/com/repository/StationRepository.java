package com.repository;

import com.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {
    Station findByStationName(String name);
    Station findByCityId(Long id);
    Station findByCityName(String name);
}
