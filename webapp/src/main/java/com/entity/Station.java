package com.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "t_station")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "station_name")
    private String stationName;

    @OneToMany(
            mappedBy = "station",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<RouteStation> routes = new ArrayList<>();

    public Station() {

    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public List<RouteStation> getRoutes() {
        return routes;
    }

    public void setRoutes(List<RouteStation> routes) {
        this.routes = routes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(id, station.id) &&
                Objects.equals(stationName, station.stationName) &&
                Objects.equals(routes, station.routes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stationName, routes);
    }
}
