package com.teddyedo.entities;

import java.io.Serializable;
import java.util.Date;
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
public class Cliente implements Serializable {

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
    private Date DataNascita;
    
    @Basic
    @Getter
    @Setter
    private String username;
    
    @Basic
    @Getter
    @Setter
    private String password;
    
    @Basic
    @Getter
    @Setter
    private String SALT;
    
    
}

