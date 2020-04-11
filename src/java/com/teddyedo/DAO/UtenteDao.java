/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teddyedo.DAO;

import com.teddyedo.entities.Utente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author edoal
 */
public class UtenteDao {
    
    private static final String PERSISTENCE_UNIT_NAME = "WebApp-TicketAssistancePU";
    private static final EntityManager em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    
    public static boolean insert(Utente u) {
        em.getTransaction().begin();
        try {
            em.persist(u);
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
    
    public List<Utente> findAll() {
        TypedQuery<Utente> typedQuery = em.createQuery("SELECT u FROM Utente u", Utente.class);
        List<Utente> utenteList = typedQuery.getResultList();
        return utenteList;
    }

   
    public Utente findById(Long id) {
        TypedQuery<Utente> typedQuery = em.createQuery("SELECT u FROM Utente u WHERE u.id=:id", Utente.class);
        typedQuery.setParameter("id", id);
        Utente utente = typedQuery.getResultList().get(0);
        return utente;
    }
}