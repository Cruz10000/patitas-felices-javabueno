package Parcial2.Mivet.Dao;

import Parcial2.Mivet.Modelo.Empleado;
import Parcial2.Mivet.Util.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAOImpl implements EmpleadoDAO {

    private Connection connection;

    public EmpleadoDAOImpl(Connection connection) {
        this.connection=connection;
    }

    @Override
    public void insertar(Empleado empleado) throws SQLException {
        String sql="INSERT INTO empleados (usuario, contrasena, nombre) VALUES (?, ?, ?)";
        try (PreparedStatement ps=connection.prepareStatement(sql)) {
            ps.setString(1,empleado.getUsuario());
            ps.setString(2,empleado.getContrasena());
            ps.setString(3,empleado.getNombre());
            ps.executeUpdate();
        }
    }

    @Override
    public Empleado buscarPorUsuarioYContrasena(String usuario, String contrasena) throws SQLException {
        String sql="SELECT*FROM empleados WHERE usuario =? AND contrasena =?";
        try (PreparedStatement ps=connection.prepareStatement(sql)) {
            ps.setString(1,usuario);
            ps.setString(2,contrasena);
            try (ResultSet rs=ps.executeQuery()) {
                if (rs.next()){
                    Empleado e=new Empleado();
                    e.setId(rs.getInt("id"));
                    e.setUsuario(rs.getString("usuario"));
                    e.setContrasena(rs.getString("contrasena"));
                    e.setNombre(rs.getString("nombre"));
                    return e;
                }
            }
        }
        return null;
    }

    @Override
    public List<Empleado>listarTodos()throws SQLException {
        List<Empleado> lista=new ArrayList<>();
        String sql="SELECT*FROM empleados";
        try (Statement st=connection.createStatement();
             ResultSet rs=st.executeQuery(sql)) {
            while (rs.next()) {
                Empleado e=new Empleado();
                e.setId(rs.getInt("id"));
                e.setUsuario(rs.getString("usuario"));
                e.setContrasena(rs.getString("contrasena"));
                e.setNombre(rs.getString("nombre"));
                lista.add(e);
            }
        }
        return lista;
    }

    @Override
    public void guardar(Empleado empleado) throws SQLException {
        insertar(empleado);
    }
}
