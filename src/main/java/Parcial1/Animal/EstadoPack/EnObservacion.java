package Parcial1.Animal.EstadoPack;

import Parcial1.Mail.EnviarMail;
import Parcial1.Mail.Mail;
import Parcial1.Animal.Mascota;

public class EnObservacion implements EstadoMascota {
    @Override
    public boolean QuiereJugar(){
        return false;
    }

    public void MostrarCuidados(Mascota mascota) {
        System.out.println("Todos los cuidados posibles:");
        mascota.MostrarCuidadosBasicos();
        System.out.println("Dar mejor alimento");
        System.out.println("Controlar hidratación");
        System.out.println("Control veterinario diario");
    }

    public void RegistrarTemperatura(double temperatura, Mascota mascota) {
        EnviarMail enviarmail = new Mail();
        enviarmail.Enviar("sistema@vet.com", "veterinario@vet.com",
                "Alerta de temperatura",
                "La mascota " + mascota.getNombreMascota() + " ha registrado temperatura: " + temperatura);
    }

}
