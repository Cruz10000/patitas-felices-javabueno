package Parcial1.Humano;

public class Adoptante extends Persona {
    private String direccionAdoptante;

    public Adoptante(String Nombre, String Apellido, int Edad) {
        super(Nombre, Apellido, Edad);
    }

    public Adoptante() {
        super();
    }

    public String getDireccion() {
        return direccionAdoptante;
    }

    public void setId(int anInt) {
    }

    public void setEdad(int i) {
    }

    public void setDireccion(String direccion){}

    public void setNombre(String nombre){

    }

    private int id;

    public int getId() {
        return id;
    }
}