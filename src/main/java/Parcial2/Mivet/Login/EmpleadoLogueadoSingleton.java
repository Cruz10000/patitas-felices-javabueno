package Parcial2.Mivet.Login;

import Parcial2.Mivet.Modelo.Empleado;

public class EmpleadoLogueadoSingleton {
    private static EmpleadoLogueadoSingleton instancia;
    private Empleado empleado;

    private EmpleadoLogueadoSingleton() {}

    public static EmpleadoLogueadoSingleton getInstance() {
        if (instancia==null) {
            instancia=new EmpleadoLogueadoSingleton();
        }
        return instancia;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado=empleado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }
}
