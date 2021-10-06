package com.emse.spring.faircorp.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="BUILDING")
public class Building {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @OneToMany(mappedBy = "building")
    private List<Room> ListRoom;


    public Building() {
    }

    public Building(String name, List<Room> ListRoom) {
        this.name = name;
        this.ListRoom = ListRoom;
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

    public  List<Room> getRoomList(){
        return ListRoom;
    }
}
