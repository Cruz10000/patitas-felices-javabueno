package Parcial1.AdopcionDoc;

import Parcial1.Animal.Gato;
import Parcial1.Humano.Adoptante;
import Parcial1.Humano.Empleado;

import java.util.Date;

public class AdopcionGato extends Adopcion {

    private Date fecha;

    public AdopcionGato(Adoptante adoptante, Gato gato, Empleado empleado) {
        super(adoptante, gato, empleado);
    }
    @Override
    protected void PasosEspecificos(){
        System.out.println("Comprobando si el adoptante tiene arenero.");
    }

    @Override
    public Date getFecha() {
        return this.fecha;
    }

}
