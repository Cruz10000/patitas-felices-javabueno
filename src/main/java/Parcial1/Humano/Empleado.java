package Parcial1.Humano;

public class Empleado extends Persona {


    public Empleado(String nombre, String apellido, String edad) {
        super(nombre, apellido, Integer.parseInt(edad));
    }

    public void setEdad(int i){
    }

}

