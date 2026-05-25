package Parcial1;

import Parcial1.AdopcionDoc.Adopcion;
import Parcial1.AdopcionDoc.AdopcionPerro;
import Parcial1.AdopcionDoc.RegistroAdopcion;
import Parcial1.Animal.Mascota;
import Parcial1.Animal.Perro;
import Parcial1.Auxi.Contenedor;
import Parcial1.Humano.Adoptante;
import Parcial1.Humano.Empleado;

public class Veterinaria {
    public static void main(String[] args) {

        Contenedor<Mascota> ContenedorMascota = new Contenedor<>();

        try {
            Adoptante adoptante = new Adoptante("Pedro", "Perez", 32);
            Empleado empleado = new Empleado("Pedra", "Peras", 40);
            Perro perro = new Perro("Milaneso", 3);
            ContenedorMascota.Agregar(perro);


            System.out.println("¿Contiene mascota? " + ContenedorMascota.ContieneMascota());
            System.out.println("¿Esta vacoo? " + ContenedorMascota.EsVacio());

            System.out.println("Promedio de edad de adoptantes: " + Servicio.PromedioEdadAdoptantes());
            System.out.println("Mascotas ordenadas por nombre:");
            Servicio.MascotasOrdenadasPorNombre().forEach(m -> System.out.println(m.getNombreMascota()));
            System.out.println("Resumen mascotas: " + Servicio.ResumenMascotas());

            Adopcion adopcion = new AdopcionPerro(adoptante, perro, empleado);
            adopcion.ProcesarAdopcion();

            RegistroAdopcion.getInstance().RegistrarAdopcion(adopcion);
        } catch (Exception e){
            System.out.println("Error en la adopcion: " + e.getMessage());
        }
    }
}

