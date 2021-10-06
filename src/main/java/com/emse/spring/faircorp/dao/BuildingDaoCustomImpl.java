package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BuildingDaoCustomImpl implements BuildingDaoCustom{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Window> FindalltheBuildingLigths(Long idBuilding){
        List<Window> listsRsltWindows= new ArrayList<Window>();
        String jpqlSelectRoom = "select r from Room r where r.building = : idBuilding";
        List<Room> lr = em.createQuery(jpqlSelectRoom, Room.class)
                .setParameter("idBuilding", idBuilding)
                .getResultList();

        Iterator<Room> iter = lr.iterator();
        int i =0, j =0;
        while (iter.hasNext()) {
            Room r = iter.next();
            String jpqlSelectWindow = "select w from Window w where w.room = : idRoom";
            List<Window> lw = em.createQuery(jpqlSelectWindow, Window.class)
                    .setParameter("idRoom", r.getId())
                    .getResultList();
            listsRsltWindows.addAll(lw);

        }
        return listsRsltWindows;
    }
}
