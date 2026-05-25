package Parcial1.Animal.EstadoPack;

import Parcial1.Animal.Mascota;

public interface EstadoMascota {
    boolean QuiereJugar();
    void MostrarCuidados(Mascota mascota);
    void RegistrarTemperatura(double temperatura, Mascota mascota);
}
