package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface WindowDaoCustom {

    // Find all Open Windows in a Room
    List<Window> findRoomOpenWindows(Long id);

    // Delete all Windows That existe in a Room

    @Modifying
    void deleteByRoom(Long IdRoom);
}
