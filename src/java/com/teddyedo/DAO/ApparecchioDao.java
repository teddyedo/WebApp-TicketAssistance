/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teddyedo.DAO;

import com.teddyedo.entities.Apparecchio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author edoal
 */
public class ApparecchioDao {
    
    private static final String PERSISTENCE_UNIT_NAME = "WebApp-TicketAssistancePU";
    private static final EntityManager em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    
    public static boolean insert(Apparecchio a) {
        em.getTransaction().begin();
        try {
            em.persist(a);
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
    
    public List<Apparecchio> findAll() {
        TypedQuery<Apparecchio> typedQuery = em.createQuery("SELECT a FROM Apparecchio a", Apparecchio.class);
        List<Apparecchio> apparecchioList = typedQuery.getResultList();
        return apparecchioList;
    }

   
    public Apparecchio findById(Long id) {
        TypedQuery<Apparecchio> typedQuery = em.createQuery("SELECT a FROM Apparecchio a WHERE a.id=:id", Apparecchio.class);
        typedQuery.setParameter("id", id);
        Apparecchio apparecchio = typedQuery.getResultList().get(0);
        return apparecchio;
    }
}
