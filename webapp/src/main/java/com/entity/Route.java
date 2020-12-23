package com.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "t_route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_station")
    private String firstStation;

    @Column(name = "last_station")
    private String lastStation;

    @Column(name = "description")
    private String description;



    @OneToMany(
            mappedBy = "route",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<RouteStation> stations = new ArrayList<>();

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "route_id")
//    private List<Train> trains;

    @OneToMany(
            mappedBy = "route",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<TrainRoute> trains = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstStation() {
        return firstStation;
    }

    public void setFirstStation(String firstStation) {
        this.firstStation = firstStation;
    }

    public String getLastStation() {
        return lastStation;
    }

    public void setLastStation(String lastStation) {
        this.lastStation = lastStation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<RouteStation> getStations() {
        return stations;
    }

    public void setStations(List<RouteStation> stations) {
        this.stations = stations;
    }

    public List<TrainRoute> getTrains() {
        return trains;
    }

    public void setTrains(List<TrainRoute> trains) {
        this.trains = trains;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Objects.equals(id, route.id) &&
                Objects.equals(firstStation, route.firstStation) &&
                Objects.equals(lastStation, route.lastStation) &&
                Objects.equals(description, route.description) &&
                Objects.equals(stations, route.stations) &&
                Objects.equals(trains, route.trains);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstStation, lastStation, description, stations, trains);
    }
}
