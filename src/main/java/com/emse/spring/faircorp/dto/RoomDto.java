package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.*;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.util.List;

public class RoomDto {
    private Long id;
    private String name;
    private int floor;
    private List<Window> ListWindow;
    private double CurrentTemperature;
    private double TargetTemperature;
    private List<Heater> HeatersList;
    private Building building;

    public RoomDto() {
    }

    public RoomDto(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.ListWindow = room.getWindows();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public List<Window> getListWindow() { return this.ListWindow; }

    public void setListRoom(List<Window> ListWindow){ this.ListWindow = ListWindow;}

    public int getFloor() {
        return this.floor;
    }

    public double getCurrentTemperature() {
        return this.CurrentTemperature;
    }

    public void setCurrentTemperature(double CurrentTemperature){
        this.CurrentTemperature = CurrentTemperature;
    }

    public double getTargetTemperature() {
        return this.TargetTemperature;
    }

    public void setTargetTemperature(double TarTargetTemperature){
        this.TargetTemperature = TargetTemperature;
    }


    public List<Heater> getHeatersList() {
        return this.HeatersList;
    }

    public void setHeatersList(List<Heater> HeatersList){
        this.HeatersList = HeatersList;
    }

    public Building getBuilding() {
        return this.building;
    }

    public void setBuilding(Building building){
        this.building = building;
    }
}