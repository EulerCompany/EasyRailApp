package com.entity;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "t_train")
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "train_name")
    private String trainName;

    @Column(name = "departure_time")
    private Date departureTime;

    @Column(name = "arrival_time")
    private Date arrivalTime;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "train_id")
    private List<Ticket> tickets;

//    @ManyToOne(
//            fetch = FetchType.LAZY,
//            optional = false
//    )
//    @JoinColumn(
//            name = "route_id",
//            nullable = false
//    )
//    private Route route;

    @OneToMany(
            mappedBy = "routes",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<TrainRoute> routes = new ArrayList<>();



    public Train() {

    }

    public Train(String trainName, Date departureTime, Date arrivalTime){
        this.trainName = trainName;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
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

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<TrainRoute> getRoutes() {
        return routes;
    }

    public void setRoutes(List<TrainRoute> routes) {
        this.routes = routes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return Objects.equals(id, train.id) &&
                Objects.equals(trainName, train.trainName) &&
                Objects.equals(departureTime, train.departureTime) &&
                Objects.equals(arrivalTime, train.arrivalTime) &&
                Objects.equals(tickets, train.tickets) &&
                Objects.equals(routes, train.routes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, trainName, departureTime, arrivalTime, tickets, routes);
    }
}
