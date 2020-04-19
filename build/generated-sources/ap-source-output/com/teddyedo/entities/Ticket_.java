package com.teddyedo.entities;

import com.teddyedo.entities.Apparecchio;
import com.teddyedo.entities.Cliente;
import com.teddyedo.entities.Utente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-19T21:01:56")
@StaticMetamodel(Ticket.class)
public class Ticket_ { 

    public static volatile SingularAttribute<Ticket, Utente> utente;
    public static volatile SingularAttribute<Ticket, String> stato;
    public static volatile SingularAttribute<Ticket, Cliente> cliente;
    public static volatile SingularAttribute<Ticket, Apparecchio> apparecchio;
    public static volatile SingularAttribute<Ticket, Long> id;
    public static volatile SingularAttribute<Ticket, Date> dataRichiesta;
    public static volatile SingularAttribute<Ticket, String> motivoRichiesta;
    public static volatile SingularAttribute<Ticket, Integer> tempoRimanente;

}