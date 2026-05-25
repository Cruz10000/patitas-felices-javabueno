package Parcial1.Animal;

public class MascotaExtra extends Mascota {

    public MascotaExtra(){
        super("",0);
    }
    @Override
    public void MostrarCuidadosBasicos(){}

    @Override
    public void MostrarCuidados(Mascota mascota) {
        System.out.println("Cuidados especiales para " + mascota.getNombreMascota());
    }

    @Override
    public void RegistrarTemperatura(double temperatura, Mascota mascota) {
        System.out.println("Registrando temperatura " + temperatura + " para la mascota " + mascota.getNombreMascota());
    }
}
