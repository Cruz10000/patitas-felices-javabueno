package Parcial1.Auxi;

import Parcial1.Animal.Mascota;

public class Contenedor<T> {

    private T contenido;

    public void Agregar(T elemento){
        this.contenido=elemento;
    }

    public T Obtener(){
        return contenido;
    }

    public boolean EsVacio(){
        return contenido==null;
    }

    public boolean ContieneMascota(){
        return contenido instanceof Mascota;
    }

    public boolean ContieneObjeto(){
        return !ContieneMascota()&&contenido!=null;
    }

}
