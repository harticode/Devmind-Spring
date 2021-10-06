package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;

import java.util.List;

public interface RoomDaoCustom {

    // Find a Room by his Name
    List<Room> findRoomByName(String name);
}
