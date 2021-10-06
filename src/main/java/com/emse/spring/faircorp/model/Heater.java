package com.emse.spring.faircorp.model;

import javax.persistence.*;

@Entity
@Table(name="HEATER")
public class Heater {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = true)
    private Long power;

    @ManyToOne
    private Room room;

    @Column(nullable = false, length = 255)
    @Enumerated(EnumType.STRING)
    private HeaterStatus HeaterStatus;

    public Heater() {
    }

    public Heater(String name, Long power) {
        this.power = power;
        this.name =name;
    }

    public Heater(Room room, String name, HeaterStatus heaterStatus ,Long power) {
        this.room = room;
        this.power = power;
        this.HeaterStatus =heaterStatus;
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

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public HeaterStatus getHeaterStatus() {
        return this.HeaterStatus;
    }

    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.HeaterStatus = heaterStatus ;
    }
}
