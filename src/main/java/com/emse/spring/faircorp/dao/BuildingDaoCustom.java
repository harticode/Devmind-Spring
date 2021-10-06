package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;

import java.util.List;

public interface BuildingDaoCustom {

    // Find all the Buildings lights (it mean the open windows that exist in the Building )
    List<Window> FindalltheBuildingLigths(Long id);
}
