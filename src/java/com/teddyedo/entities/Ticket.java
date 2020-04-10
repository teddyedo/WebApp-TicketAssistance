package com.teddyedo.entities;

import javax.persistence.*;
import java.util.Date;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Allari Edoardo
 * @version 1.0.0 - 14/03/2020
 * 
 */

 @Entity
 @NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    @Setter
    private Date dataRichiesta;

    @Basic
    @Getter
    @Setter
    private String motivoRichiesta;

    @Basic
    @Getter
    @Setter
    private String stato;

    @Basic
    @Getter
    @Setter
    private int tempoRimanente;
    
    @Getter
    @Setter
    @ManyToOne(targetEntity = Apparecchio.class)
    private Apparecchio apparecchio;

    @Getter
    @Setter
    @ManyToOne(targetEntity = Utente.class)
    private Utente utente;
    
    @Getter
    @Setter
    @ManyToOne(targetEntity = Cliente.class)
    private Cliente cliente;    
}

