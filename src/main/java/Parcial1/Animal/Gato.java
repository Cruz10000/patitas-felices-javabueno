package Parcial1.Animal;

import Parcial1.Animal.EstadoPack.RequiereCuidadosEspeciales;

public class Gato extends Mascota implements RequiereCuidadosEspeciales,PesoMascota{
    private double peso;

    public Gato(String Nombre, int Edad) {
        super(Nombre, Edad);
        this.InfoCuidado = "Los gatos necesitan caja de arena";
        this.peso = 0.0;
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