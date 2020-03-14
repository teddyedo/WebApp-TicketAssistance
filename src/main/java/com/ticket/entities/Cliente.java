package com.ticket.entities;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Allari Edoardo
 * @version 1.0.0 - 14/03/2020
 * 
 */

 @Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long Id;

    @Basic
    @Getter
    @Setter
    private String Nome;

    @Basic
    @Getter
    @Setter
    private String Cognome;

    @Basic
    @Getter
    @Setter
    private String Telefono;

    @Basic
    @Getter
    @Setter
    private String Email;

    @Basic
    @Getter
    @Setter
    private String Indirizzo;

    @Basic
    @Getter
    @Setter
    private String CAP;

    @Temporal(TemporalType.DATE)
    @Getter
    @Setter
    private String DataNascita;


    public Cliente() {
    }

    
    public Cliente(long id, String nome, String cognome, String telefono, String email, String indirizzo, String cAP,
            String dataNascita) {
        this.Id = id;
        this.Nome = nome;
        this.Cognome = cognome;
        this.Telefono = telefono;
        this.Email = email;
        this.Indirizzo = indirizzo;
        this.CAP = cAP;
        this.DataNascita = dataNascita;
    }

    
}

