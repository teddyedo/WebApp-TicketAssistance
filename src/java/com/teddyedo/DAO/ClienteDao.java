/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teddyedo.DAO;

import com.teddyedo.entities.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author edoal
 */
public class ClienteDao {
    
    private static final String PERSISTENCE_UNIT_NAME = "WebApp-TicketAssistancePU";
    private static final EntityManager em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    
    public static boolean insert(Cliente c) {
        em.getTransaction().begin();
        try {
            em.persist(c);
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
    
    public static List<Cliente> findAll() {
        TypedQuery<Cliente> typedQuery = em.createQuery("SELECT c FROM Cliente c", Cliente.class);
        List<Cliente> clienteList = typedQuery.getResultList();
        return clienteList;
    }

   
    public static Cliente findById(Long id) {
        TypedQuery<Cliente> typedQuery = em.createQuery("SELECT c FROM Cliente c WHERE c.id=:id", Cliente.class);
        typedQuery.setParameter("id", id);
        Cliente cliente = typedQuery.getResultList().get(0);
        return cliente;
    }
    
    public static Cliente findByUsername(String username) {
        TypedQuery<Cliente> typedQuery = em.createQuery("SELECT c FROM Cliente c WHERE c.username=:username", Cliente.class);
        typedQuery.setParameter("username", username);
        Cliente cliente = typedQuery.getResultList().get(0);
        return cliente;
    }
}
