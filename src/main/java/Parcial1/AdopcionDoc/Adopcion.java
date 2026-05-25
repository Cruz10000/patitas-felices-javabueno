package Parcial1.AdopcionDoc;

import Parcial1.Humano.Adoptante;
import Parcial1.Humano.Empleado;
import Parcial1.Animal.Mascota;

import java.util.Date;

public abstract class Adopcion implements FechaAdopcion {
    private Mascota mascota;
    private Adoptante adoptante;
    private Empleado empleado;
    private Date fecha;
    protected Date FechaAdopcion = new Date();

    public Adopcion(Adoptante adoptante, Mascota mascota, Empleado empleado) {
        this.mascota = mascota;
        this.adoptante = adoptante;
        this.empleado = this.empleado;
        this.fecha = new Date();
    }

    public final void ProcesarAdopcion() throws Exception {
        ValidarDatos();
        RegistrarAdoptante();
        RegistrarEmpleado();
        RegistrarMascota();
        PasosEspecificos();
        GenerarTicket();
    }

    protected void RegistrarAdoptante(){
        System.out.println("Adoptante: " + adoptante.getNombre());
    }

    protected void RegistrarEmpleado(){
        System.out.println("Empleado: " + empleado.getNombre());
    }

    protected void RegistrarMascota(){
        System.out.println("Mascota: " + mascota.getNombreMascota());
    }

    protected void GenerarTicket(){
        System.out.println("Adopcion procesada exitosamente.");
    }

    protected abstract void PasosEspecificos();

    protected void ValidarDatos() throws Exception{
        if(adoptante==null||adoptante.getNombre()==null||adoptante.getNombre().isEmpty()){
            throw new Exception("El nombre del adoptante es obligatorio.");
        }
        if(mascota==null){
            throw new Exception("No se puede adoptar una mascota nula.");
        }
    }

    public Adoptante getAdoptante() {
        return adoptante;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public Date getFechaAdopcion() {
        return FechaAdopcion;
    }

    public boolean esReciente(Date desde){
        return false;
    }

}
