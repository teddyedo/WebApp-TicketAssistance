package com.teddyedo.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.*;

/**
 * 
 * @author Allari Edoardo
 * @version 1.0.0 - 14/03/2020
 * 
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
public class PDA implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;
    
    @Getter
    @Setter
    @Basic
    private String nomeNegozio;
    
    @Getter
    @Setter
    @Basic
    private String luogo;
    
    
}

