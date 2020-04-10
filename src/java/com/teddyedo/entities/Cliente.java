package com.teddyedo.entities;

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
}

