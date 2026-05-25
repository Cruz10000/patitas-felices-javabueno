package Parcial1.Animal;

public class PesodeMascota extends Mascota implements PesoMascota {

    private double Peso;

    public PesodeMascota(Mascota base, double peso) {
        super(base.getNombreMascota(), base.getEdad());
        this.Peso = peso;
    }

    public double getPeso() {
        return Peso;
    }

    @Override
    public void RegistrarTemperatura(double temperatura, Mascota mascota) {
        System.out.println("Registrando temperatura "+temperatura+" para "+mascota.getNombreMascota());
    }

    @Override
    public void MostrarCuidados(Mascota mascota) {
        System.out.println("Cuidados especiales para "+mascota.getNombreMascota());
    }
}
