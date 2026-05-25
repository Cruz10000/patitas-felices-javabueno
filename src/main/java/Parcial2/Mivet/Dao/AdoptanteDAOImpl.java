package Parcial2.Mivet.Dao;

import Parcial1.Humano.Adoptante;
import Parcial2.Mivet.Util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdoptanteDAOImpl extends AdoptanteDAO {

    private final Connection connection;

    public AdoptanteDAOImpl() throws SQLException {
        this.connection=Conexion.getInstance().getConnection();
    }

    @Override
    public void insertar(Adoptante adoptante) {
        String sql="INSERT INTO adoptantes (nombre, edad, direccion) VALUES (?, ?, ?)";

        try (PreparedStatement ps=connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1,adoptante.getNombre());
            ps.setInt(2,adoptante.getEdad());
            ps.setString(3,adoptante.getDireccion());
            ps.executeUpdate();

            try (var rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    adoptante.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al insertar adoptante en la base de datos");
        }
    }
}
