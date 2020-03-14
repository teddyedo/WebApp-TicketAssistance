package com.ticket.entities;

import javax.persistence.*;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Allari Edoardo
 * @version 1.0.0 - 14/03/2020
 * 
 */

 @Entity
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

    public Ticket() {
    }

    public Ticket(long id, Date dataRichiesta, String motivoRichiesta, String stato, int tempoRimanente,
            Apparecchio apparecchio, Utente utente, Cliente cliente) {
        this.id = id;
        this.dataRichiesta = dataRichiesta;
        this.motivoRichiesta = motivoRichiesta;
        this.stato = stato;
        this.tempoRimanente = tempoRimanente;
        this.apparecchio = apparecchio;
        this.utente = utente;
        this.cliente = cliente;
    }
   
    

    
}

