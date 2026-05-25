package Parcial1.Animal;

import Parcial1.Animal.EstadoPack.EstadoMascota;
import Parcial1.Animal.EstadoPack.Saludable;
import Parcial1.Cuidado.Cuidado;

import java.util.ArrayList;
import java.util.List;

public abstract class Mascota implements EstadoMascota {
    private String NombreMascota;
    private int Edad;
    protected String InfoCuidado;
    private List<Cuidado> cuidados = new ArrayList<>();
    private EstadoMascota Estado;
    private double peso;
    private String especie;
    private int idMascota;

    public Mascota(String nombre, int edad) {
        this.NombreMascota = nombre;
        this.Edad = edad;
    }

    private EstadoMascota estado = new Saludable();
    public EstadoMascota getEstadoActual() {
        return estado;
    }

    public void AgregarCuidado(Cuidado cuidado) {
        cuidados.add(cuidado);
    }

    public String getNombreMascota() {
        return NombreMascota;
    }

    public void CambiarEstado(EstadoMascota nuevoEstado) {
        this.Estado = nuevoEstado;
    }

    public boolean QuiereJugar() {
        return Estado.QuiereJugar();
    }

    public void MostrarCuidados() {
        Estado.MostrarCuidados(this);
    }

    public void RegistrarTemperatura(double temp) {
        Estado.RegistrarTemperatura(temp, this);
    }

    public void MostrarCuidadosBasicos() {
        for (Cuidado c : cuidados) {
            System.out.println("- " + c.InformacionCuidado());
        }
        System.out.println("- " + InfoCuidado);


    }

    public boolean requiereCuidadosEspeciales() {
        return true;
    }

    public double getPeso(){
        return 0;
    }

    public boolean tienePeso(){
        return false;
    }

    public int getEdad() {
        return Edad;
    }

    public Integer getIdAdoptante(int id) {
        return null;
    }

    public void setId(int anInt) {
    }

    public double getPesoMascota(){
        return this.peso;
    }

    public double setPesoMascota(double peso){
        return this.peso=peso;
    }

    public String setNombreMascota(String text){
        return NombreMascota;
    }

    public void setPeso(double v) {

    }

    public void setEspecie(String text) {
    }

    public void setFechaNacimiento(String text) {
    }

    public String getEspecie(){
        return especie;
    }

    public int getId() {
        return idMascota;
    }
}