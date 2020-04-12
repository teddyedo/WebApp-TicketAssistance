/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teddyedo.DAO;

import com.teddyedo.entities.Ticket;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author edoal
 */
public class TicketDao {
    
    private static final String PERSISTENCE_UNIT_NAME = "WebApp-TicketAssistancePU";
    private static final EntityManager em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    
    public static boolean insert(Ticket t) {
        em.getTransaction().begin();
        try {
            em.persist(t);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }
    
    public static List<Ticket> findAll() {
        TypedQuery<Ticket> typedQuery = em.createQuery("SELECT t FROM Ticket t", Ticket.class);
        List<Ticket> ticketList = typedQuery.getResultList();
        return ticketList;
    }

   
    public static Ticket findById(Long id) {
        TypedQuery<Ticket> typedQuery = em.createQuery("SELECT t FROM Ticket t WHERE t.id=:id", Ticket.class);
        typedQuery.setParameter("id", id);
        Ticket ticket = typedQuery.getResultList().get(0);
        return ticket;
    }
}
