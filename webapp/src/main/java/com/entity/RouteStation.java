package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_route_station")
public class RouteStation {

    @EmbeddedId
    private RouteStationId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("routeId")
    private Route route;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("stationId")
    private Station station;

    @Column(name = "order_station")
    private Long order;

    public RouteStation() {}

    public RouteStation(Route route, Station station) {
        this.route = route;
        this.station = station;
    }

}
