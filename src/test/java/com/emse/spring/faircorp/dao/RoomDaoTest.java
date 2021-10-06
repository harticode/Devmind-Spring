package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

// The Class to Test all the Dao Room Class (test the queries)
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RoomDaoTest {

    // Dependency Injection of the class RoomDao into the RoomDaoTest class
    @Autowired
    private RoomDao roomDao;

    // Test if the Room that have an id equal to the Long 10 and that have an Name equale to "Heater1" and have the Heater Status : ON.
    @Test
    public void shouldFindRoom(){
        Room Room = roomDao.getOne(-10L);
        Assertions.assertThat(Room.getName()).isEqualTo("Room1");
        Assertions.assertThat(Room.getCurrentTemperature()).isEqualTo(22.3);
    }

    // Test the findRoomByName function that describe the Querry to find  a Room by his Name.
    @Test
    public void shouldFindRoomByName() {
        List<Room> result = roomDao.findRoomByName("Room1");
        Assertions.assertThat(result.size()).isEqualTo(1);
    }

}
