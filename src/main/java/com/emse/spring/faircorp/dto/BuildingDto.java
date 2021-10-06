package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.*;

import java.util.List;

public class BuildingDto {
    private Long id;
    private String name;
    private List<Room> ListRoom;

    public BuildingDto() {
    }

    public BuildingDto(Building building) {
        this.id = building.getId();
        this.name = building.getName();
        this.ListRoom = building.getRoomList();
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

    public List<Room> getListRoom() { return this.ListRoom; }

    public void setListRoom(List<Room> listRoom){ this.ListRoom = listRoom;}

}