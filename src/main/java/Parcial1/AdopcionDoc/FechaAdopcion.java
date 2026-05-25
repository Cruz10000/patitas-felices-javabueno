package Parcial1.AdopcionDoc;

import java.util.Date;

public interface FechaAdopcion {

    Date getFecha();

    default boolean esReciente(Date desde){                                                         //sin default no dej
        return getFecha()!= null && getFecha().after(desde);
    }

}
