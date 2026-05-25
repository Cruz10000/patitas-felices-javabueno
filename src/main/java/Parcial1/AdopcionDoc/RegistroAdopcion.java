package Parcial1.AdopcionDoc;

import java.util.ArrayList;
import java.util.List;

public class RegistroAdopcion {

    private static RegistroAdopcion Ins;

    private List<Adopcion>ListaAdopciones=new ArrayList<>();

    private RegistroAdopcion(){}

    public static RegistroAdopcion getInstance(){
        if(Ins==null){
            Ins=new RegistroAdopcion();                                     //Lo de singeton
        }
        return Ins;
    }

    public void RegistrarAdopcion(Adopcion adopcion){
        ListaAdopciones.add(adopcion);
    }
    public List<Adopcion> ObtenerAdopciones(){

        return ListaAdopciones;
    }

}
