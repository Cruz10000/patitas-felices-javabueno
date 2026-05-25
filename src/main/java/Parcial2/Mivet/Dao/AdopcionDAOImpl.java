package Parcial2.Mivet.Dao;

import Parcial2.Mivet.Util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdopcionDAOImpl implements AdopcionDAO {

    private final Connection connection;

    public AdopcionDAOImpl() throws SQLException {
        this.connection=Conexion.getInstance().getConnection();
    }

    @Override
    public void insertar(int idAdoptante, int idMascota, int idEmpleado) {
        String sql="INSERT INTO adopciones (id_adoptante, id_mascota, id_empleado) VALUES (?, ?, ?)";

        try (PreparedStatement ps=connection.prepareStatement(sql)) {
            ps.setInt(1,idAdoptante);
            ps.setInt(2,idMascota);
            ps.setInt(3,idEmpleado);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al insertar adopción en la base de datos");
        }
    }
}
