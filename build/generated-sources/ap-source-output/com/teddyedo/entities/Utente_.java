package com.teddyedo.entities;

import com.teddyedo.entities.PDA;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-11T19:07:13")
@StaticMetamodel(Utente.class)
public class Utente_ { 

    public static volatile SingularAttribute<Utente, String> SALT;
    public static volatile SingularAttribute<Utente, String> Username;
    public static volatile SingularAttribute<Utente, Long> id;
    public static volatile SingularAttribute<Utente, String> Nome;
    public static volatile SingularAttribute<Utente, PDA> pda;
    public static volatile SingularAttribute<Utente, String> Cognome;
    public static volatile SingularAttribute<Utente, String> Password;

}