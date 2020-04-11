package com.teddyedo.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-10T11:56:55")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> Email;
    public static volatile SingularAttribute<Cliente, String> CAP;
    public static volatile SingularAttribute<Cliente, String> Telefono;
    public static volatile SingularAttribute<Cliente, String> Indirizzo;
    public static volatile SingularAttribute<Cliente, Long> Id;
    public static volatile SingularAttribute<Cliente, String> Nome;
    public static volatile SingularAttribute<Cliente, String> Cognome;
    public static volatile SingularAttribute<Cliente, Date> DataNascita;

}