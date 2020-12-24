package com.entity;
import javax.persistence.*;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "t_city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "city_id")
    private List<Station> stations;

    public City() {

    }

    public City(String name) {
        this();
        this.name =name;
    }

    public Station getFirstStation() {
        return stations.get(0);
    }
    public void setFirstStation(Station station) {
        stations.add(0, station);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }
}
