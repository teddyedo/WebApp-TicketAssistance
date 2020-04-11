package com.teddyedo.entities;

import java.io.Serializable;
import javax.persistence.*;
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
public class Utente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

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

       
}

