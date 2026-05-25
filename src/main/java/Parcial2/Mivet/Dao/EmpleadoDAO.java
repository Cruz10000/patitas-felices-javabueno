package Parcial2.Mivet.Dao;

import Parcial2.Mivet.Modelo.Empleado;
import java.sql.SQLException;
import java.util.List;

public interface EmpleadoDAO {

    void insertar(Empleado empleado)throws SQLException;

    Empleado buscarPorUsuarioYContrasena(String usuario, String contrasena) throws SQLException;

    List<Empleado> listarTodos()throws SQLException;

    void guardar(Empleado empleado)throws SQLException;
}
