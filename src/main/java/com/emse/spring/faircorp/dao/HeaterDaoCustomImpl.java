package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Iterator;
import java.util.List;

import static java.lang.System.*;

public class HeaterDaoCustomImpl implements HeaterDaoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Heater> deleteAllHeater(){
        String jpql = "delete from Heater h";
        return em.createQuery(jpql, Heater.class)
                .getResultList();
    }


    @Override
    public int deleteByRoom(Long IdRoom) {
        String jpqlSelect = "select r from Room r where r.id = : IdRoom";
        List<Room> lr = em.createQuery(jpqlSelect, Room.class)
                .setParameter("IdRoom", IdRoom)
                .getResultList();
        Room r = lr.get(0);
        List<Heater> lh = r.getHeatersList();
        int i = 0;
        Iterator<Heater> iter = lh.iterator();

        while (iter.hasNext()) {
            Heater h = iter.next();
            String jpqlDelete = "delete from Heater h where h.id = : id";

            em.createQuery(jpqlDelete, Heater.class)
                    .setParameter("id", h.getId())
                    .getResultList();
            System.out.println("ssddddddddddd");
            i++;
        }
        return 1; // Success to delete all the Heater in a Room
    }
}
