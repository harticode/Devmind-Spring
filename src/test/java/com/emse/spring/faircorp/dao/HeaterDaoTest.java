package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;

// The Class to Test all the Dao Window Class (test the queries)
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class HeaterDaoTest {

    // Dependency Injection of the class HeaterDao into the HeaterDaoTest Class
    @Autowired
    private HeaterDao heaterDao;
    // Dependency Injection of the class RoomDao into the HeaterDaoTest Class
    @Autowired
    private RoomDao roomDao;

    // Test if the Heater that have an id equal to the Long 10 and that have an Name equale to "Heater1" and have the Heater Status : ON.
    @Test
    public void shouldFindHeater(){
        Heater Heater = heaterDao.getOne(-10L);
        Assertions.assertThat(Heater.getName()).isEqualTo("Heater1");
        Assertions.assertThat(Heater.getHeaterStatus()).isEqualTo(HeaterStatus.ON);
    }


    // Test if the deleteAllHeater function Delete all The Heaters that exist in our database.
    @Test
    public void shouldDeleteHeaters() {
        heaterDao.deleteAll();
    }

    // Test if the deleteByRoom function Delete all The Heaters that exist in a Room By his Id Room.
    @Test
    public void shouldDeleteHeatersRoom() {
        Room room = roomDao.getOne(-10L);
        List<Long> roomIds = room.getWindows().stream().map(Window::getId).collect(Collectors.toList());
        Assertions.assertThat(roomIds.size()).isEqualTo(2);

        heaterDao.deleteByRoom(-10L);
        List<Heater> result = heaterDao.findAllById(roomIds);
        Assertions.assertThat(result).isEmpty();

    }
}
