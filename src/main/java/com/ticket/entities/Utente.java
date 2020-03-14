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
public class Utente {

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
    private String Username;

    @Basic
    @Getter
    @Setter
    private String Password;

    @Basic
    @Getter
    @Setter
    private String SALT;

    
    @Getter
    @Setter
    @ManyToOne(targetEntity = PDA.class)
    private PDA pda;

    public Utente() {
    }

    public Utente(long id, String nome, String cognome, String username, String password, String sALT, PDA pda) {
        this.Id = id;
        this.Nome = nome;
        this.Cognome = cognome;
        this.Username = username;
        this.Password = password;
        this.SALT = sALT;
        this.pda = pda;
    }

    
}

