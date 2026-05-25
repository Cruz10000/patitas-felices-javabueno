package Parcial2.Mivet.Dao;

import Parcial1.Animal.Mascota;
import Parcial2.Mivet.Util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.sql.ResultSet;

public class MascotaDAOImpl extends MascotaDAO {

    private final Connection connection;

    public MascotaDAOImpl() throws SQLException {
        this.connection=Conexion.getInstance().getConnection();
    }

    @Override
    public void insertar(Mascota mascota) throws SQLException {
        Objects.requireNonNull(mascota, "La mascota no puede ser null");
        String sql = "INSERT INTO mascotas (nombre, tipo, edad, peso, id_adoptante) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps=connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1,Objects.requireNonNull(mascota.getNombreMascota(),"El nombre no puede ser null"));
            ps.setString(2,mascota.getClass().getSimpleName());
            ps.setInt(3,mascota.getEdad());
            ps.setDouble(4,mascota.getPeso());
            
            Integer idAdoptante=mascota.getIdAdoptante(adoptante.getId());
            if (idAdoptante == null || idAdoptante <= 0) {
                throw new IllegalArgumentException("ID de adoptante invalido");
            }
            ps.setInt(5, idAdoptante);
            
            ps.executeUpdate();
            
            try (ResultSet rs=ps.getGeneratedKeys()){
                if (rs.next()){
                    mascota.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error al insertar mascota en la base de datos", e);
        }
    }
}