package com.example.watermyplants.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "plants")
public class Plant extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long plantsid;

    @Column(nullable = false)
    private String species;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String time;

    @Column(nullable = false)
    private String location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid",
            nullable = false)
    @JsonIgnoreProperties({"plants", "hibernateLazyInitializer"})
    private User user;

    public Plant()
    {
    }

    public Plant(String species, String name, String time, String location, User user) {
        this.species = species;
        this.name = name;
        this.time = time;
        this.location = location;
        this.user = user;
    }

    public Plant(long plantsid, User currentUser) {
        super();
    }

    public long getPlantid() {
        return plantsid;
    }

    public void setPlantid(long plantid) {
        this.plantsid = plantid;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
