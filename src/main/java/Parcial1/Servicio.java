package Parcial1;

import Parcial1.AdopcionDoc.Adopcion;
import Parcial1.AdopcionDoc.RegistroAdopcion;
import Parcial1.Animal.Mascota;

import java.util.*;
import java.util.stream.Collectors;

public class Servicio{                                              //la de streams

    public static List<Mascota> mascotasConCuidadosEspeciales(){
        return RegistroAdopcion.getInstance().ObtenerAdopciones().stream()
                .map(Adopcion::getMascota)
                .filter(Mascota::requiereCuidadosEspeciales)
                .collect(Collectors.toList());
    }
    public static List<String> NombresDeAdoptantes(){
        return RegistroAdopcion.getInstance().ObtenerAdopciones().stream()
                .map(a->a.getAdoptante().getNombre())
                .distinct()
                .collect(Collectors.toList());
    }

    public static Map<String, Long> ContarMascotasPorEspecie(){
        return RegistroAdopcion.getInstance().ObtenerAdopciones().stream()
                .map(a -> a.getMascota().getClass().getSimpleName())               //x especie
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));             //puedo usar esto?
    }

    public static List<Mascota> MascotasOrdenadasPorNombre(){
        return RegistroAdopcion.getInstance().ObtenerAdopciones().stream()
                .map(Adopcion::getMascota)
                .sorted(Comparator.comparing(Mascota::getNombreMascota))
                .collect(Collectors.toList());
    }

    public static List<Mascota> MascotasPorPesoMinimo(double pesoMinimo){
        return RegistroAdopcion.getInstance().ObtenerAdopciones().stream()
                .map(Adopcion::getMascota)
                .filter(m -> m.tienePeso() && m.getPeso() > pesoMinimo)
                .collect(Collectors.toList());
    }

    public static String ConcatenarNombresMascotas() {
        return RegistroAdopcion.getInstance().ObtenerAdopciones().stream()
                .map(a -> a.getMascota().getNombreMascota())
                .collect(Collectors.joining(", "));
    }

    public static double PromedioEdadAdoptantes(){
        return RegistroAdopcion.getInstance().ObtenerAdopciones().stream()
                .mapToInt(a -> a.getAdoptante().getEdad())
                .average().orElse(0);
    }

    public static List<Adopcion> AdopcionesRecientes(){
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -30);
        Date hace30dias=cal.getTime();

        return RegistroAdopcion.getInstance().ObtenerAdopciones().stream()
                .filter(a -> a.esReciente(hace30dias))
                .collect(Collectors.toList());

    }

    public static List<String> ResumenMascotas(){
        return RegistroAdopcion.getInstance().ObtenerAdopciones().stream()
                .map(a -> {
                    Mascota m = a.getMascota();
                    return m.getNombreMascota() + " (" + m.getClass().getSimpleName() + ")";
                }).collect(Collectors.toList());
    }

    public static boolean HayAdopcionesSinMascota(){
        return RegistroAdopcion.getInstance().ObtenerAdopciones().stream()
                .anyMatch(a->a.getMascota()==null);
    }
}
