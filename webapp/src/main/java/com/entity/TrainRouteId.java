package com.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TrainRouteId implements Serializable{

    @Column(name = "route_id")
    private Long routeId;

    @Column(name = "train_id")
    private Long trainId;



    public TrainRouteId() {

    }

    public TrainRouteId(Long routeId, Long trainId) {
        this();
        this.routeId = routeId;
        this.trainId = trainId;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainRouteId that = (TrainRouteId) o;
        return Objects.equals(routeId, that.routeId) &&
                Objects.equals(trainId, that.trainId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeId, trainId);
    }
}
