package com.emse.spring.faircorp.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ROOM")
public class Room {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private int floor;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = true)
    private double CurrentTemperature;

    @Column(nullable = true)
    private double TargetTemperature;

    @OneToMany(mappedBy = "room")
    private List<Heater> HeatersList;

    @OneToMany(mappedBy = "room")
    private List<Window> WindowList;

    @ManyToOne
    private Building building;

    public Room() {
    }

    public Room(String name, double CurrentTemp, double TargetTemp, int floor) {
        this.CurrentTemperature = CurrentTemp;
        this.TargetTemperature = TargetTemp;
        this.floor = floor;
        this.name =name;
    }

    public Long getId() {
        return this.id;
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

    public double getCurrentTemperature() {
        return this.CurrentTemperature;
    }

    public List<Heater> getHeatersList(){
        return HeatersList;
    }

    public List<Window> getWindows(){
        return WindowList;
    }

}
