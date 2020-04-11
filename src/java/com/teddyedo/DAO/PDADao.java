/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teddyedo.DAO;

import com.teddyedo.entities.PDA;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author edoal
 */
public class PDADao {
    
    private static final String PERSISTENCE_UNIT_NAME = "WebApp-TicketAssistancePU";
    private static final EntityManager em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    
    public static boolean insert(PDA p) {
        em.getTransaction().begin();
        try {
            em.persist(p);
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
    
    public List<PDA> findAll() {
        TypedQuery<PDA> typedQuery = em.createQuery("SELECT p FROM PDA p", PDA.class);
        List<PDA> pdaList = typedQuery.getResultList();
        return pdaList;
    }

   
    public PDA findById(Long id) {
        TypedQuery<PDA> typedQuery = em.createQuery("SELECT p FROM PDA p WHERE p.id=:id", PDA.class);
        typedQuery.setParameter("id", id);
        PDA pda = typedQuery.getResultList().get(0);
        return pda;
    }
}
