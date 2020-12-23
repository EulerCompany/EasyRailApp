package com.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_route_station")
public class TrainRoute {

    @EmbeddedId
    private TrainRouteId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("routeId")
    private Route route;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("trainId")
    private Train train;

    @Column(name = "departure_time")
    private Date departureTime;

    @Column(name = "arrival_time")
    private Date arrivalTime;

    public TrainRoute () {}

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public TrainRoute(Train  train, Route route) {
        this.route = route;
        this.train = train;
        this.id = new TrainRouteId(route.getId(), train.getId());
    }


}
