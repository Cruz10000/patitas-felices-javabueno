package Parcial1.Animal.EstadoPack;

import Parcial1.Animal.Mascota;

import java.util.Random;

public class NoSaludable implements EstadoMascota {

    public boolean QuiereJugar() {
        return new Random().nextBoolean();
    }

    public void MostrarCuidados(Mascota mascota){
        System.out.println("Cuidados normales y especiales:");
        mascota.MostrarCuidadosBasicos();
        System.out.println("Dar mejor alimento");
        System.out.println("Controlar hidratacion");
    }

    public void RegistrarTemperatura(double temperatura, Mascota mascota) {
    }

}
