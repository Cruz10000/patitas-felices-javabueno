package Parcial1.Cuidado;

public class CuidadoImpl implements Cuidado {
    private String Tipo;
    private String Frecuencia;

    public CuidadoImpl(String tipo, String frecuencia) {
        this.Tipo = tipo;
        this.Frecuencia = frecuencia;
    }

    @Override
    public String InformacionCuidado() {
        return Tipo + " Frecuencia: " + Frecuencia;
    }
}