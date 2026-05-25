package Parcial1.Humano;

public abstract class Persona {
    private String Nombre;
    private String Apellido;
    private int Edad;

    public Persona(String nombre, String apellido, int edad) {
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.Edad = edad;
    }

    public Persona() {

    }

    public String getNombre() {
        return Nombre;
    }

    public int getEdad() {
        return Edad;
    }

}