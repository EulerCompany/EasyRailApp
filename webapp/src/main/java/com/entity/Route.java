package com.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Objects.equals(id, route.id) &&
                Objects.equals(firstStation, route.firstStation) &&
                Objects.equals(lastStation, route.lastStation) &&
                Objects.equals(description, route.description) &&
                Objects.equals(stations, route.stations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstStation, lastStation, description, stations);
    }
}
