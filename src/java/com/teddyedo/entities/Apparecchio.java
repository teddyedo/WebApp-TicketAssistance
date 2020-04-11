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
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
public class Apparecchio implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;
    
    @Basic
    @Getter
    @Setter
    private String marca;
    
    @Basic
    @Getter
    @Setter
    private String modello;

}

