package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Iterator;
import java.util.List;

public class WindowDaoCustomImpl implements WindowDaoCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Window> findRoomOpenWindows(Long id) {
        String jpql = "select w from Window w where w.room.id = :id and w.windowStatus= :status";
        return em.createQuery(jpql, Window.class)
                .setParameter("id", id)
                .setParameter("status", WindowStatus.OPEN)
                .getResultList();
    }


    @Override
    @Transactional
    public void deleteByRoom(Long IdRoom) {
        String jpqlSelect = "select r from Room r where r.id = :IdRoom";
        List<Room> lr = em.createQuery(jpqlSelect)
                .setParameter("IdRoom", IdRoom)
                .getResultList();
        Room r = lr.get(0);
        List<Window> lh = r.getWindows();
        int i = 0;
        Iterator<Window> iter = lh.iterator();
        while (iter.hasNext()) {
            Window w = iter.next();
            String jpqlDelete = "delete from Window w where w.id = :id";
            em.createQuery(jpqlDelete)
                    .setParameter("id", w.getId())
                    .executeUpdate();
            i++;
        }

    }


}
