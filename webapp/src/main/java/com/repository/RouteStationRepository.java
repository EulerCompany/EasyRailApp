package com.repository;

import com.entity.RouteStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RouteStationRepository extends JpaRepository<RouteStation, Long> {
    List<RouteStation> findByStationId(Long id);
    RouteStation findByRouteId(Long id);

}
