package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;

import java.util.List;

public interface HeaterDaoCustom {

    // Delete all Heater that exist
    List<Heater> deleteAllHeater();

    //Delete all Heater in Room
    int deleteByRoom(Long IdRoom);



}
