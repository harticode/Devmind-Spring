package com.emse.spring.faircorp.dao;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
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
class WindowDaoTest {

    @Autowired
    private WindowDao windowDao;

    // Dependency Injection of the class RoomDao into the WindowDaoTest class
    @Autowired
    private RoomDao roomDao;

    // Test if the Window that have an id equal to the Long 10 and that have an Name equal to "Window 1" and have the Window Status : CLOSED, exist or not
    @Test
    public void shouldFindAWindow() {
        Window window = windowDao.getOne(-10L);
        Assertions.assertThat(window.getName()).isEqualTo("Window 1");
        Assertions.assertThat(window.getWindowStatus()).isEqualTo(WindowStatus.CLOSED);
    }

    // Test the findRoomOpenWindows function that describe the Querry that find  all the windows that is OPEN in a specific Room by his Name Room.
    @Test
    public void shouldFindRoomOpenWindows() {
        List<Window> result = windowDao.findRoomOpenWindows(-9L);
        Assertions.assertThat(result)
                .hasSize(1)
                .extracting("id", "windowStatus")
                .containsExactly(Tuple.tuple(-8L, WindowStatus.OPEN));
    }

    // Test the findRoomOpenWindows function that describe the Querry that find  all the windows that is OPEN in a specific Room by his Name Room.
    @Test
    public void shouldNotFindRoomOpenWindows() {
        List<Window> result = windowDao.findRoomOpenWindows(-10L);
        Assertions.assertThat(result).isEmpty();
    }

    // Test if the deleteByRoom function Delete all The Windows that exist in a Room By his Id Room.
    @Test
    public void shouldDeleteWindowsRoom() {
        Room room = roomDao.getOne(-10L);
        List<Long> roomIds = room.getWindows().stream().map(Window::getId).collect(Collectors.toList());
        Assertions.assertThat(roomIds.size()).isEqualTo(2);

        windowDao.deleteByRoom(-10L);
        List<Window> result = windowDao.findAllById(roomIds);
        Assertions.assertThat(result).isEmpty();

    }
}
