package com.repository;

import com.entity.RouteStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteStationRepository extends JpaRepository<RouteStation, Long> {
    List<RouteStation> findByStationId(Long id);
    RouteStation findByRouteId(Long id);

}
