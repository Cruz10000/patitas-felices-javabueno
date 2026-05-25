package Parcial1.Animal.EstadoPack;

import Parcial1.Animal.Mascota;

public class Saludable implements EstadoMascota {

    public boolean QuiereJugar(){
        return true;
    }

    public void MostrarCuidados(Mascota mascota){
        System.out.println("Cuidados normales: ");
        mascota.MostrarCuidadosBasicos();
    }

    public void RegistrarTemperatura(double temperatura, Mascota mascota){
    }

}
