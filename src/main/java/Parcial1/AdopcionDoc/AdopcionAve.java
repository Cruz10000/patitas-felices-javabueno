package Parcial1.AdopcionDoc;

import Parcial1.Humano.Adoptante;
import Parcial1.Humano.Empleado;
import Parcial1.Animal.Mascota;

import java.util.Date;

public class AdopcionAve extends Adopcion {

    private Date fecha;

    public AdopcionAve(Adoptante adoptante, Mascota ave, Empleado empleado){
        super(adoptante, ave, empleado);
    }

    @Override
    protected void PasosEspecificos(){
        System.out.println("Recomendando cuidados de jaula para el ave.");
    }

    @Override
    public Date getFecha() {
        return this.fecha;
    }
}
