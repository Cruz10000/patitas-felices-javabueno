package Parcial1.AdopcionDoc;

import Parcial1.Animal.Perro;
import Parcial1.Humano.Adoptante;
import Parcial1.Humano.Empleado;

import java.util.Date;

public class AdopcionPerro extends Adopcion {

    private Date fecha;

    public AdopcionPerro(Adoptante adoptante, Perro perro, Empleado empleado) {
        super(adoptante, perro, empleado);
    }
    @Override
    protected void PasosEspecificos() {
        System.out.println("Verificando vacunas obligatorias para el perro.");
    }

    @Override
    public Date getFecha() {
        return this.fecha;
    }

}
