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

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
    }

    public RouteStation(Route route, Station station) {
        this.route = route;
        this.station = station;
        this.id = new RouteStationId(route.getId(), station.getId());
    }

}
