package Parcial1.Animal;

import Parcial1.Animal.EstadoPack.RequiereCuidadosEspeciales;

public class Perro extends Mascota implements RequiereCuidadosEspeciales,PesoMascota{
    private double peso;
    public Perro(String Nombre, int Edad) {
        super(Nombre, Edad);
        this.InfoCuidado = "Los perros necesitan salir 4 veces al dia";
        this.peso = 0.0;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public void RegistrarTemperatura(double temperatura, Mascota mascota) {
        System.out.println("Registrando temperatura "+temperatura+"para la mascota "+mascota.getNombreMascota());
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