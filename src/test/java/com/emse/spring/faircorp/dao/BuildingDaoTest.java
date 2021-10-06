package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.HeaterStatus;
import com.emse.spring.faircorp.model.Window;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;


// The Class to Test all the Dao Building Class (test the queries)
@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BuildingDaoTest {
    // Dependency Injection of the class BuildingDao into the BuildingDaoTest Class
    @Autowired
    private BuildingDao BuildingDao;

    // Dependency Injection of the class WindowDao into the BuildingDaoTest Class
    @Autowired
    private WindowDao WindowDao;

    // Test if the Buolding that have an id equal to the Long -10 and that have an Name equal to "MainBuilding" and have the Heater Status : ON.
    @Test
    public void shouldFindBuilding(){
        Building Building = BuildingDao.getOne(-10L);
        Assertions.assertThat(Building.getName()).isEqualTo("MainBuilding");
    }
    // Test if all the we can find all the windows (source of the ligths) of the Building that have an Id equal to -10.
    @Test
    public void shouldFindalltheBuildingLigths(){
        List<Window> result = BuildingDao.FindalltheBuildingLigths(-10L);
        Assertions.assertThat(result.size()).isEqualTo(4); // Equal to 4 because we have 4 Windows in ourDatabase.
    }
}
