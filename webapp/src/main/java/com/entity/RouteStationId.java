package com.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RouteStationId implements Serializable{

    @Column(name = "route_id")
    private Long routeId;

    @Column(name = "station_id")
    private Long stationId;



    public RouteStationId() {

    }

    public RouteStationId(Long routeId, Long stationId) {
        this();
        this.routeId = routeId;
        this.stationId = stationId;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteStationId that = (RouteStationId) o;
        return Objects.equals(routeId, that.routeId) &&
                Objects.equals(stationId, that.stationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeId, stationId);
    }
}
