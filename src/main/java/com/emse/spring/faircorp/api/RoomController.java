package com.emse.spring.faircorp.api;


import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.dto.BuildingDto;
import com.emse.spring.faircorp.dto.HeaterDto;
import com.emse.spring.faircorp.dto.RoomDto;
import com.emse.spring.faircorp.dto.WindowDto;
import com.emse.spring.faircorp.model.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController // RestController is a Spring stereotype to mark a class as a rest service
@RequestMapping("/api/rooms") // @RequestMapping is used to define a global URL prefix used to manage a resource (in our example all requests that start with /api/windows will be handle by this controller)
@Transactional // @Transactional is used to delegate a transaction opening to Spring. Spring will initiate a transaction for each entry point of this controller. This is important because with Hibernate you cannot execute a query outside of a transaction.
public class RoomController {

    private final RoomDao roomDao;


    public RoomController(RoomDao roooDao) { // DAOs used by this controller are injected via constructor
        this.roomDao = roooDao;

    }

    @GetMapping // @GetMapping indicates that the following method will respond to a GET request. This method will return a window list. We transform our entities Window in WindowDto.
    public List<RoomDto> findAll() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());  // We use Java Stream API to manipulate our data
    }

    @GetMapping(path = "/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomDao.findById(id).map(RoomDto::new).orElse(null); // We use Java Stream API to manipulate our data
    }

    @PostMapping // @PostMapping indicates that the following method will respond to a POST request (for saving).
    public RoomDto create(@RequestBody RoomDto dto) {
        // HeaterDto must always contain the window room
        Room room = null;
        // On creation id is not defined
        if (dto.getId() == null) {
            room = roomDao.save(new Room(dto.getName(), dto.getCurrentTemperature(), dto.getTargetTemperature(), dto.getFloor()));
        }
        else {
            room = roomDao.getOne(dto.getId());  // For an update you don’t need to call the DAO save method. Method getOne load the persisted data and all changes on this object (attached to a persistent context) will be updated when the transaction will be commited.4
        }
        return new RoomDto(room);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        roomDao.deleteById(id);
    }
}

