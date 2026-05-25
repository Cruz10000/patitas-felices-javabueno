package Parcial1.Animal;

import Parcial1.Animal.EstadoPack.EstadoMascota;
import Parcial1.Animal.EstadoPack.RequiereCuidadosEspeciales;

public class Ave extends Mascota implements EstadoMascota{
    private double peso;
   public Ave(String Nombre, int Edad) {
        super(Nombre, Edad);
        this.InfoCuidado = "Las aves necesitan jaula";
    }

    @Override
    public void RegistrarTemperatura(double temperatura, Mascota mascota) {
        System.out.println("Registrando temperatura "+temperatura+" para la mascota "+mascota.getNombreMascota());
    }

    @Override
    public void MostrarCuidados(Mascota mascota) {
        System.out.println("Cuidados especiales para "+mascota.getNombreMascota());
    }

    @Override
    public boolean requiereCuidadosEspeciales() {
        return true;
    }

    @Override
    public double getPeso(){
        return this.peso;
    }

    @Override
    public boolean tienePeso(){
        return true;
    }

}
